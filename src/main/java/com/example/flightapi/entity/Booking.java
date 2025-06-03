package com.example.flightapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;
	
	@Column(name = "booking_no", nullable = false, length = 100)
    private String bookingNo;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "passenger_id", nullable = false)
	private Integer passengerId;

	@Column(name = "flight_id_outbound", nullable = false)
	private Integer flightIdOutbound;

	@Column(name = "flight_id_return")
	private Integer flightIdReturn;

	@Column(name = "outbound_date", nullable = false)
	private String outboundDate;

	@Column(name = "return_date")
	private String returnDate;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "class", nullable = false, length = 1)
	private String flightClass;

	@Column(name = "booking_time", nullable = false)
	private String bookingTime;

	@Column(name = "price", nullable = false)
	private BigDecimal price;
}