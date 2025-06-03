package com.example.flightapi.service;

import java.util.List;

import com.example.flightapi.entity.Booking;
import com.example.flightapi.projection.BookingWithPassengerProjection;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<BookingWithPassengerProjection> getBookingsByUserId(Integer userId);
    List<BookingWithPassengerProjection> getLatestBookingsByUserId(Integer userId);
    void deleteBooking(String bookingNo);
    void cancelBooking(String bookingNo);
    void payBooking(String bookingNo);
}