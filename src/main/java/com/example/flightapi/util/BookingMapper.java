package com.example.flightapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.flightapi.dto.BookingRequestDTO;
import com.example.flightapi.dto.BookingResponseDTO;
import com.example.flightapi.dto.BookingWithPassengerDTO;
import com.example.flightapi.entity.Booking;
import com.example.flightapi.projection.BookingWithPassengerProjection;

@Component
public class BookingMapper {

	public Booking toEntity(BookingRequestDTO dto) {
		if (dto == null)
			return null;
		return Booking.builder().bookingNo(dto.getBookingNo()).userId(dto.getUserId()).passengerId(dto.getPassengerId())
				.flightIdOutbound(dto.getFlightIdOutbound()).flightIdReturn(dto.getFlightIdReturn())
				.outboundDate(dto.getOutboundDate()).returnDate(dto.getReturnDate()).status(dto.getStatus())
				.flightClass(dto.getFlightClass()).bookingTime(dto.getBookingTime()).price(dto.getPrice()).build();
	}

	public BookingResponseDTO toResponseDTO(BookingWithPassengerDTO dto) {
		if (dto == null)
			return null;

		return BookingResponseDTO.builder().bookingId(dto.getBookingId()).bookingNo(dto.getBookingNo())
				.userId(dto.getUserId()).passengerId(dto.getPassengerId()).firstName(dto.getFirstName())
				.lastName(dto.getLastName()).flightIdOutbound(dto.getFlightIdOutbound())
				.flightIdReturn(dto.getFlightIdReturn()).outboundDate(dto.getOutboundDate())
				.returnDate(dto.getReturnDate()).status(dto.getStatus()).flightClass(dto.getFlightClass())
				.bookingTime(dto.getBookingTime()).price(dto.getPrice()).build();
	}

	public BookingResponseDTO toResponseDTO(Booking dto) {
		if (dto == null)
			return null;

		return BookingResponseDTO.builder().bookingId(dto.getBookingId()).bookingNo(dto.getBookingNo())
				.userId(dto.getUserId()).passengerId(dto.getPassengerId()).flightIdOutbound(dto.getFlightIdOutbound())
				.flightIdReturn(dto.getFlightIdReturn()).outboundDate(dto.getOutboundDate())
				.returnDate(dto.getReturnDate()).status(dto.getStatus()).flightClass(dto.getFlightClass())
				.bookingTime(dto.getBookingTime()).price(dto.getPrice()).build();
	}
	
	public BookingWithPassengerDTO mapToDto(BookingWithPassengerProjection projection) {
	    return new BookingWithPassengerDTO(
	        projection.getBookingId(),
	        projection.getBookingNo(),
	        projection.getUserId(),
	        projection.getPassengerId(),
	        projection.getFirstName(),
	        projection.getLastName(),
	        projection.getFlightIdOutbound(),
	        projection.getFlightIdReturn(),
	        projection.getOutboundDate(),
	        projection.getReturnDate(),
	        projection.getStatus(),
	        projection.getFlightClass(),
	        projection.getBookingTime(),
	        projection.getPrice()
	    );
	}
	
	public List<BookingResponseDTO> toResponseDTOList(List<BookingWithPassengerProjection> list) {
		if (list.isEmpty())
			return Collections.emptyList();
		return list.stream().map(this::mapToDto).map(this::toResponseDTO).collect(Collectors.toList());
	}
}