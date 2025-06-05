package com.example.flightapi.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.config.BaseResponse;
import com.example.flightapi.dto.BookingRequestDTO;
import com.example.flightapi.dto.BookingResponseDTO;
import com.example.flightapi.entity.Booking;
import com.example.flightapi.projection.BookingWithPassengerProjection;
import com.example.flightapi.service.BookingService;
import com.example.flightapi.util.BookingMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "Booking API", description = "APIs for Manage Booking Info")
@Validated
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingMapper bookingMapper;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/getHistory")
	public BaseResponse<List<BookingResponseDTO>> getBookingHistorys(@RequestParam("userId") Integer userId) {
		List<BookingWithPassengerProjection> bookingInfoList = bookingService.getBookingsByUserId(userId);
		List<BookingResponseDTO> resBookings = bookingMapper.toResponseDTOList(bookingInfoList);
		return BaseResponse.success(resBookings);
	}

	@GetMapping("/getCurrent")
	public BaseResponse<List<BookingResponseDTO>> getCurrentBookingInfo(@RequestParam("userId") Integer userId) {
		List<BookingWithPassengerProjection> bookingInfoList = bookingService.getLatestBookingsByUserId(userId);
		List<BookingResponseDTO> resBookings = bookingMapper.toResponseDTOList(bookingInfoList);
		return BaseResponse.success(resBookings);
	}

	@PostMapping("/create")
	public BaseResponse<BookingResponseDTO> createBookingInfo(@RequestBody BookingRequestDTO dto) {
		Booking booking = bookingMapper.toEntity(dto);
		Booking savedBooking = bookingService.createBooking(booking);
		if (savedBooking == null) {
			String msg = messageSource.getMessage("booking.create_failed", null, Locale.ENGLISH);
			return BaseResponse.failure(400, msg);
		}
		BookingResponseDTO responseDTO = bookingMapper.toResponseDTO(savedBooking);
		return BaseResponse.success(responseDTO);

	}

	@PostMapping("/pay/{bookingNo}")
	public BaseResponse<BookingResponseDTO> payBooking(@PathVariable("bookingNo") String bookingNo) {
		bookingService.payBooking(bookingNo);
		return BaseResponse.success(null);
	}

	@PostMapping("/cancel/{bookingNo}")
	public BaseResponse<BookingResponseDTO> cancelBooking(@PathVariable("bookingNo") String bookingNo) {
		bookingService.cancelBooking(bookingNo);
		return BaseResponse.success(null);
	}

	@PostMapping("/delete/{bookingNo}")
	public BaseResponse<BookingResponseDTO> deleteBooking(@PathVariable("bookingNo") String bookingNo) {
		bookingService.deleteBooking(bookingNo);
		return BaseResponse.success(null);
	}

}
