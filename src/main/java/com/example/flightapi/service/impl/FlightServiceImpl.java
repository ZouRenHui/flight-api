package com.example.flightapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flightapi.projection.FlightWithAirportInfoProjection;
import com.example.flightapi.repository.FlightRepository;
import com.example.flightapi.service.FlightService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

	private final FlightRepository flightRepository;

	@Override
	public List<FlightWithAirportInfoProjection> getFlightHasStop(String depCity, String arrCity) {
		return flightRepository.getFlightHasStop(depCity, arrCity);
	}

	@Override
	public List<FlightWithAirportInfoProjection> getFlightNoStop(String depCity, String arrCity) {
		return flightRepository.getFlightNoStop(depCity, arrCity);
	}

	@Override
	public List<FlightWithAirportInfoProjection> getFlight(String depCity, String arrCity) {
		return flightRepository.getFlightByCity(depCity, arrCity);
	}

}
