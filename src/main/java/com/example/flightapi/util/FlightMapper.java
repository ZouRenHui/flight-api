package com.example.flightapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.flightapi.dto.FlightRequestDTO;
import com.example.flightapi.dto.FlightResponseDTO;
import com.example.flightapi.dto.FlightWithAirportInfoDTO;
import com.example.flightapi.entity.Flight;
import com.example.flightapi.projection.FlightWithAirportInfoProjection;

@Component
public class FlightMapper {

	public Flight toEntity(FlightRequestDTO dto) {
		if (dto == null)
			return null;

		return Flight.builder().flightNumber(dto.getFlightNumber()).departureAirportId(dto.getDepartureAirportId())
				.arrivalAirportId(dto.getArrivalAirportId()).stopAirportId(dto.getStopAirportId())
				.departureTime(dto.getDepartureTime()).arrivalTime(dto.getArrivalTime()).stopTime(dto.getStopTime())
				.overnightFlag(dto.getOvernightFlag()).planeType(dto.getPlaneType()).companyName(dto.getCompanyName())
				.priceClassF(dto.getPriceClassF()).priceClassC(dto.getPriceClassC()).priceClassY(dto.getPriceClassY())
				.build();
	}

	public FlightResponseDTO toResponseDTO(FlightWithAirportInfoDTO dto) {
		if (dto == null)
			return null;

		FlightResponseDTO.FlightResponseDTOBuilder builder = FlightResponseDTO.builder().flightId(dto.getFlightId())
				.flightNumber(dto.getFlightNumber())

				.departureAirportId(dto.getDepartureAirportId()).depCode(dto.getDepCode()).depName(dto.getDepName())

				.arrivalAirportId(dto.getArrivalAirportId()).arrCode(dto.getArrCode()).arrName(dto.getArrName())

				.departureTime(dto.getDepartureTime()).arrivalTime(dto.getArrivalTime())
				.overnightFlag(dto.getOvernightFlag()).planeType(dto.getPlaneType()).companyName(dto.getCompanyName())

				.priceClassF(dto.getPriceClassF()).priceClassC(dto.getPriceClassC()).priceClassY(dto.getPriceClassY());

		// 判断是否有经停
		if (dto.getStopAirportId() != null) {
			builder.stopAirportId(dto.getStopAirportId()).stopCode(dto.getStopCode()).stopName(dto.getStopName())
					.stopCity(dto.getStopCity()).stopTime(dto.getStopTime());
		}

		return builder.build();
	}

	public FlightWithAirportInfoDTO mapToDto(FlightWithAirportInfoProjection projection) {
		return new FlightWithAirportInfoDTO(
				projection.getFlightId(), 
				projection.getFlightNumber(),
				projection.getDepartureAirportId(), 
				projection.getDepCode(), 
				projection.getDepName(),
				projection.getDepCity(),
				projection.getArrivalAirportId(), 
				projection.getArrCode(), 
				projection.getArrName(),
				projection.getArrCity(),
				projection.getStopAirportId(), 
				projection.getStopCode(), 
				projection.getStopName(),
				projection.getStopCity(),
				projection.getDepartureTime(), 
				projection.getArrivalTime(), 
				projection.getStopTime(),
				projection.getOvernightFlag(), 
				projection.getPlaneType(), 
				projection.getCompanyName(),
				projection.getPriceClassF(), 
				projection.getPriceClassC(), 
				projection.getPriceClassY());
	}

	public List<FlightResponseDTO> toResponseDTOList(List<FlightWithAirportInfoProjection> flights) {
		if (flights == null || flights.isEmpty())
			return Collections.emptyList();
		return flights.stream().map(this::mapToDto).map(this::toResponseDTO).collect(Collectors.toList());
	}
}
