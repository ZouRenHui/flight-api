package com.example.flightapi.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
	@Id
	@Column(name = "flight_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;
	
	@Column(name = "flight_number", nullable = false, length = 10)
	private String flightNumber;
	
	@Column(name = "departure_airport_id", nullable = false)
    private Integer departureAirportId;

    @Column(name = "arrival_airport_id", nullable = false)
    private Integer arrivalAirportId;

    @Column(name = "stop_airport_id")
    private Integer stopAirportId;

    @Column(name = "departure_time", nullable = false, length = 8)
    private String departureTime;

    @Column(name = "arrival_time", nullable = false, length = 8)
    private String arrivalTime;

    @Column(name = "stop_time", length = 8)
    private String stopTime;

    @Column(name = "overnight_flag", nullable = false)
    private Integer overnightFlag;

    @Column(name = "plane_type", nullable = false, length = 20)
    private String planeType;

    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Column(name = "price_class_f", precision = 8, scale = 2)
    private BigDecimal priceClassF;

    @Column(name = "price_class_c", precision = 8, scale = 2)
    private BigDecimal priceClassC;

    @Column(name = "price_class_y", nullable = false, precision = 8, scale = 2)
    private BigDecimal priceClassY;
}
