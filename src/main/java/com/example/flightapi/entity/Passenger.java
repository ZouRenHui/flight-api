package com.example.flightapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passenger")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {

	@Id
	@Column(name = "passenger_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerId;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "email", nullable = true, length = 100)
	private String email;
}