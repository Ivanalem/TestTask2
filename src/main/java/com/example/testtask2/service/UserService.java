package com.example.testtask2.service;

import com.example.testtask2.dto.JwtAuthenticationDto;
import com.example.testtask2.dto.RefreshTokenDto;
import com.example.testtask2.dto.UserCredentialsDto;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public interface UserService {
    JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException;
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception;
}
