package com.example.flightapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flightapi.entity.Booking;
import com.example.flightapi.projection.BookingWithPassengerProjection;
import com.example.flightapi.repository.BookingRepository;
import com.example.flightapi.service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
	
	public static final int STATUS_PAID = 1;
	public static final int STATUS_CANCELED = 9;
	
	private final BookingRepository bookingRepository;

	@Override
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<BookingWithPassengerProjection> getBookingsByUserId(Integer userId) {
		return bookingRepository.findByUserId(userId);
	}
	
	@Override
	public List<BookingWithPassengerProjection> getLatestBookingsByUserId(Integer userId) {
		return bookingRepository.findAllByUserIdAndLatestBookingTime(userId);
	}

	@Override
	public void deleteBooking(String bookingNo) {
		bookingRepository.deleteByBookingNo(bookingNo);
	}

	@Override
	public void cancelBooking(String bookingNo) {
		bookingRepository.updateStatus(STATUS_CANCELED, bookingNo);
	}

	@Override
	public void payBooking(String bookingNo) {
		bookingRepository.updateStatus(STATUS_PAID, bookingNo);
	}

}
