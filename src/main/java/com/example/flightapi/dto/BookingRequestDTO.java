package com.example.flightapi.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {

	private String bookingNo;
    private Integer userId;
    private Integer passengerId;
    private Integer flightIdOutbound;
    private Integer flightIdReturn;
    private String outboundDate;
    private String returnDate;
    private Integer status;
    private String flightClass;
    private String bookingTime;
    private BigDecimal price;
}