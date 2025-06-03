package com.example.flightapi.entity;

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
@Table(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airport {
	@Id
	@Column(name = "airport_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airportId;

	@Column(name = "code", nullable = false, length = 10)
	private String code;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "city", nullable = false, length = 100)
	private String city;
}
