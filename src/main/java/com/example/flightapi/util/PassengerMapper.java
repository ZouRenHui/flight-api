package com.example.flightapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.flightapi.dto.PassengerRequestDTO;
import com.example.flightapi.dto.PassengerResponseDTO;
import com.example.flightapi.entity.Passenger;

@Component
public class PassengerMapper {

	public Passenger toEntity(PassengerRequestDTO dto) {
		if (dto == null)
			return null;
		return Passenger.builder()
				.userId(dto.getUserId())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.build();
	}

	public PassengerResponseDTO toResponseDTO(Passenger passenger) {
		if (passenger == null)
			return null;
		return PassengerResponseDTO.builder()
				.passengerId(passenger.getPassengerId())
				.userId(passenger.getUserId())
				.firstName(passenger.getFirstName())
				.lastName(passenger.getLastName())
				.email(passenger.getEmail())
				.build();
	}

	public List<PassengerResponseDTO> toResponseDTOList(List<Passenger> passengers) {
		if (passengers == null || passengers.isEmpty())
			return Collections.emptyList();
		return passengers.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

}
