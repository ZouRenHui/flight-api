package com.example.flightapi.service;

import java.util.List;

import com.example.flightapi.entity.Passenger;

public interface PassengerService {
	Passenger createPassenger(Passenger passenger);
	List<Passenger> getPassengerByUserId(Integer userId);
	void deletePassenger(Integer passengerId);
}
