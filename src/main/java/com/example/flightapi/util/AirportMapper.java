package com.example.flightapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.flightapi.dto.AirportRequestDTO;
import com.example.flightapi.dto.AirportResponseDTO;
import com.example.flightapi.entity.Airport;

@Component
public class AirportMapper {

	public Airport toEntity(AirportRequestDTO dto) {
		if (dto == null)
			return null;
		return Airport.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.city(dto.getCity())
				.build();
	}

	public AirportResponseDTO toResponseDTO(Airport airport) {
		if (airport == null)
			return null;
		return AirportResponseDTO.builder()
				.airportId(airport.getAirportId())
				.code(airport.getCode())
				.name(airport.getName())
				.city(airport.getCity())
				.build();
	}

	public List<AirportResponseDTO> toResponseDTOList(List<Airport> airports) {
		if (airports.isEmpty())
			return Collections.emptyList();
		return airports.stream().map(this::toResponseDTO).collect(Collectors.toList());
	}
}
