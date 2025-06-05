package com.example.flightapi.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.config.BaseResponse;
import com.example.flightapi.dto.FlightResponseDTO;
import com.example.flightapi.projection.FlightWithAirportInfoProjection;
import com.example.flightapi.service.FlightService;
import com.example.flightapi.util.FlightMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/flights")
@Tag(name = "Flight API", description = "APIs for Get Flight Info")
@Validated
public class FlightController {

	@Autowired
	private FlightService flightService;

	@Autowired
	private FlightMapper flightMapper;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public BaseResponse<List<FlightResponseDTO>> getFlights(@RequestParam("withStop") Integer withStop,
			@RequestParam("hasReturn") Integer hasReturn, @RequestParam("depCity") String depCity,
			@RequestParam("arrCity") String arrCity) {
		List<FlightWithAirportInfoProjection> flights;
		
		switch (withStop) {
			case 0 -> flights = flightService.getFlight(depCity, arrCity);
			case 1 -> flights = flightService.getFlightHasStop(depCity, arrCity);
			default -> flights = flightService.getFlightNoStop(depCity, arrCity);
		}

		if (hasReturn == 2) {
			switch (withStop) {
				case 0 -> flights.addAll(flightService.getFlight(arrCity, depCity));
				case 1 -> flights.addAll(flightService.getFlightHasStop(arrCity, depCity));
				default -> flights.addAll(flightService.getFlightNoStop(arrCity, depCity));
			}
		}
		if (flights.isEmpty()) {
			String msg = messageSource.getMessage("flight.not_found", null, Locale.ENGLISH);
			return BaseResponse.failure(400, msg);
		}
		List<FlightResponseDTO> responseDTOs = flightMapper.toResponseDTOList(flights);
		return BaseResponse.success(responseDTOs);
	}
}
