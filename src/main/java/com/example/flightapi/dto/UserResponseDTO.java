package com.example.flightapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private Integer gender;
    private String country;
    private String phone;
}