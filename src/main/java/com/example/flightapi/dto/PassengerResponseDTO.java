package com.example.flightapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerResponseDTO {
    private Integer passengerId;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
}