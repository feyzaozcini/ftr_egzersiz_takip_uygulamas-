package com.project.designapp.controller;


import com.project.designapp.dto.JwtAuthenticationResponse;
import com.project.designapp.dto.RefreshTokenRequest;
import com.project.designapp.dto.SignUpRequest;
import com.project.designapp.dto.SigninRequest;
import com.project.designapp.entities.User;
import com.project.designapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> sigin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.sigin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }



}
