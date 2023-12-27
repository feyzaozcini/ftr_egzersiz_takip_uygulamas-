package com.project.designapp.services.impl;

import com.project.designapp.dto.JwtAuthenticationResponse;
import com.project.designapp.dto.RefreshTokenRequest;
import com.project.designapp.dto.SignUpRequest;
import com.project.designapp.dto.SigninRequest;
import com.project.designapp.entities.Role;
import com.project.designapp.entities.User;
import com.project.designapp.repos.UserRepository;
import com.project.designapp.services.AuthenticationService;
import com.project.designapp.services.JWTService;
import jakarta.servlet.http.PushBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private final UserServiceImpl userService;
    public User signup(SignUpRequest signUpRequest){
        User user =new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstname());
        user.setLastName(signUpRequest.getLastname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse sigin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));

        var user=userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        var jwt=jwtService.generateToken(user);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);

        JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();

        User currentUser= (User) userService.userDetailsService().loadUserByUsername(signinRequest.getEmail());

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        jwtAuthenticationResponse.setEmail(signinRequest.getEmail());
        jwtAuthenticationResponse.setFirstname(currentUser.getFirstName());
        return jwtAuthenticationResponse;
    }


    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail=jwtService.extractUserName(refreshTokenRequest.getToken());
        User user=userRepository.findByEmail(userEmail).orElseThrow();

        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
            var jwt=jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;

        }
        return null;
    }

}
