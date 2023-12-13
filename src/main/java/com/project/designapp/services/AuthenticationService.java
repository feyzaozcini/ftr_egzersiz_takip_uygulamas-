package com.project.designapp.services;

import com.project.designapp.dto.JwtAuthenticationResponse;
import com.project.designapp.dto.RefreshTokenRequest;
import com.project.designapp.dto.SignUpRequest;
import com.project.designapp.dto.SigninRequest;
import com.project.designapp.entities.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse sigin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
