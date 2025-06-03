package com.example.flightapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportRequestDTO {
    private String code;
    private String name;
    private String city;
}