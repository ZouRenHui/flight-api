package com.example.flightapi.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightRequestDTO {
    private String flightNumber;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private Integer stopAirportId;
    private String departureTime;
    private String arrivalTime;
    private String stopTime;
    private Integer overnightFlag;
    private String planeType;
    private String companyName;
    private BigDecimal priceClassF;
    private BigDecimal priceClassC;
    private BigDecimal priceClassY;
}