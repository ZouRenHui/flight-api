package com.example.flightapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.config.BaseResponse;
import com.example.flightapi.dto.AirportResponseDTO;
import com.example.flightapi.service.AirportService;
import com.example.flightapi.util.AirportMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin(origins = "*") // 临时处理跨域问题（开发阶段）
@Tag(name = "Airport API", description = "API for Get Airports")
@Validated
public class AirportController {

	@Autowired
	private AirportService airportService;

	@Autowired
	private AirportMapper airportMapper;

	@GetMapping
	public BaseResponse<List<AirportResponseDTO>> getAllAirports() {
		List<AirportResponseDTO> airports = airportMapper.toResponseDTOList(airportService.getAllAirports());
		return BaseResponse.success(airports);
	}
}
