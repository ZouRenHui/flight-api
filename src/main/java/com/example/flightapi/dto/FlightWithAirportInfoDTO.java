package com.example.flightapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightWithAirportInfoDTO {
	private Integer flightId;
	private String flightNumber;

	private Integer departureAirportId;
	private String depCode;
	private String depName;
	private String depCity;

	private Integer arrivalAirportId;
	private String arrCode;
	private String arrName;
	private String arrCity;

	private Integer stopAirportId;
	private String stopCode;
	private String stopName;
	private String stopCity;

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