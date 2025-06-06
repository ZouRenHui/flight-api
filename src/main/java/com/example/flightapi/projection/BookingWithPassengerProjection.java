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

    // Outbound flight info
    String getOutboundDepCity();
    String getOutboundDepAirportName();
    String getOutboundDepAirportCode();
    String getOutboundDepTime();
    String getOutboundArrCity();
    String getOutboundArrAirportName();
    String getOutboundArrAirportCode();
    String getOutboundArrTime();

    // Return flight info
    String getReturnDepCity();
    String getReturnDepAirportName();
    String getReturnDepAirportCode();
    String getReturnDepTime();
    String getReturnArrCity();
    String getReturnArrAirportName();
    String getReturnArrAirportCode();
    String getReturnArrTime();
}
