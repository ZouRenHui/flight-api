package com.example.flightapi.projection;

import java.math.BigDecimal;

public interface BookingWithPassengerProjection {
	Integer getBookingId();

	String getBookingNo();

	Integer getUserId();

	Integer getPassengerId();

	String getFirstName();

	String getLastName();

	Integer getFlightIdOutbound();

	Integer getFlightIdReturn();

	String getOutboundDate();

	String getReturnDate();

	Integer getStatus();

	String getFlightClass();

	String getBookingTime();

	BigDecimal getPrice();
}
