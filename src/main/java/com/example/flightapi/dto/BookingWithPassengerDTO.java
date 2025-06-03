package com.example.flightapi.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingWithPassengerDTO {
	private Integer bookingId;
	private String bookingNo;

	private Integer userId;
	private Integer passengerId;
	private String firstName;
	private String lastName;

	private Integer flightIdOutbound;
	private Integer flightIdReturn;

	private String outboundDate;
	private String returnDate;

	private Integer status;
	private String flightClass;
	private String bookingTime;

	private BigDecimal price;
}
