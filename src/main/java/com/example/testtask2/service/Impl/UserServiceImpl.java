package com.example.testtask2.service.Impl;

import com.example.testtask2.dto.JwtAuthenticationDto;
import com.example.testtask2.dto.RefreshTokenDto;
import com.example.testtask2.dto.UserCredentialsDto;
import com.example.testtask2.exception.BadRequestException;
import com.example.testtask2.model.User;
import com.example.testtask2.repository.UserRepository;
import com.example.testtask2.security.jwt.JwtService;
import com.example.testtask2.service.UserService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    private User findByName(String username) throws Exception {
        return userRepository.findByUserName(username).orElseThrow(()->
                new Exception(String.format("User with this name %s not found", username)));
    }

    @Override
    public JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        User user = findByCredentials(userCredentialsDto);
        return jwtService.generateAuthToken(user.getUserName());
    }

    @Override
    public JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if(refreshToken != null && jwtService.validateToken(refreshToken)) {
            User user = findByName(jwtService.getUsernameFromToken(refreshToken));
            return jwtService.refreshBaseToken(user.getUserName(), refreshToken);
        }
        throw new BadRequestException("Refresh token is required");
    }
    private User findByCredentials(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        Optional<User> optionalUser = userRepository.findByUserName(userCredentialsDto.getUsername());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())){
                return user;
            }
        }
        throw new BadRequestException("Invalid password");
    }
}
