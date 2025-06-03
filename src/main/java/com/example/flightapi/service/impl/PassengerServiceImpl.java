package com.example.flightapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flightapi.entity.Passenger;
import com.example.flightapi.repository.PassengerRepository;
import com.example.flightapi.service.PassengerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
	
	private final PassengerRepository passengerRepository;


	@Override
	public Passenger createPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public List<Passenger> getPassengerByUserId(Integer userId) {
		return passengerRepository.findByUserId(userId)
				.stream()
                .toList();
	}

	@Override
	public void deletePassenger(Integer passengerId) {
		passengerRepository.deleteById(passengerId);
	}

}
