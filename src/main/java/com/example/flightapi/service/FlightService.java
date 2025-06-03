package com.example.flightapi.service;

import java.util.List;

import com.example.flightapi.projection.FlightWithAirportInfoProjection;

public interface FlightService {
    List<FlightWithAirportInfoProjection> getFlightHasStop(String depCity, String arrCity);
    List<FlightWithAirportInfoProjection> getFlightNoStop(String depCity, String arrCity);
    List<FlightWithAirportInfoProjection> getFlight(String depCity, String arrCity);
}