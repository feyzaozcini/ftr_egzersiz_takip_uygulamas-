package com.project.designapp.dto;


import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    private String email;

    private String firstname;

}
