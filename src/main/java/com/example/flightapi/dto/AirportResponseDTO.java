package com.example.flightapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportResponseDTO {
    private Integer airportId;
    private String code;
    private String name;
    private String city;
}