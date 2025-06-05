package com.example.flightapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.config.BaseResponse;
import com.example.flightapi.dto.PassengerRequestDTO;
import com.example.flightapi.dto.PassengerResponseDTO;
import com.example.flightapi.entity.Passenger;
import com.example.flightapi.service.PassengerService;
import com.example.flightapi.util.PassengerMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/passenger")
@Tag(name = "Passenger API", description = "APIs for Manage Passenger Info")
@Validated
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private PassengerMapper passengerMapper;

	@GetMapping
	public BaseResponse<List<PassengerResponseDTO>> getPassengers(@RequestParam("userId") Integer userId) {
		List<PassengerResponseDTO> passengers = passengerMapper
				.toResponseDTOList(passengerService.getPassengerByUserId(userId));
		return BaseResponse.success(passengers);
	}

	@PostMapping("/create")
	public BaseResponse<PassengerResponseDTO> createPassenger(@RequestBody PassengerRequestDTO dto) {
		Passenger passenger = passengerMapper.toEntity(dto);
		PassengerResponseDTO responseDTO = passengerMapper.toResponseDTO(passengerService.createPassenger(passenger));
		return BaseResponse.success(responseDTO);
	}

	@DeleteMapping("/delete/{id}")
	public BaseResponse<PassengerResponseDTO> deletePassenger(@PathVariable("id") Integer passengerId) {
		passengerService.deletePassenger(passengerId);
		return BaseResponse.success(null);
	}
}
