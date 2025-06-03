package com.example.flightapi.projection;

import java.math.BigDecimal;

public interface FlightWithAirportInfoProjection {
	Integer getFlightId();
	
	String getFlightNumber();

	Integer getDepartureAirportId();
	
	String getDepCode();
	
	String getDepName();
	
	String getDepCity();

	Integer getArrivalAirportId();
	
	String getArrCode();
	
	String getArrName();
	
	String getArrCity();

	Integer getStopAirportId();
	
	String getStopCode();
	
	String getStopName();
	
	String getStopCity();

	String getDepartureTime();
	
	String getArrivalTime();
	
	String getStopTime();

	Integer getOvernightFlag();
	
	String getPlaneType();
	
	String getCompanyName();

	BigDecimal getPriceClassF();
	
	BigDecimal getPriceClassC();
	
	BigDecimal getPriceClassY();

}
