package com.example.flightapi.service.impl;

import org.springframework.stereotype.Service;

import com.example.flightapi.entity.Passenger;
import com.example.flightapi.entity.User;
import com.example.flightapi.repository.PassengerRepository;
import com.example.flightapi.repository.UserRepository;
import com.example.flightapi.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	private final PassengerRepository passengerRepository;

	@Override
	public User createUser(User user) {
		User savedUser = userRepository.save(user);
		if (savedUser != null && savedUser.getUserId() != null) {
			Passenger passenger = new Passenger();
			passenger.setUserId(savedUser.getUserId());
			passenger.setEmail(savedUser.getEmail());
			passenger.setFirstName(savedUser.getFirstName());
			passenger.setLastName(savedUser.getLastName());
			passengerRepository.save(passenger);
		}
		return savedUser;
	}

	@Override
	public User userLogin(User user) {
		User resUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
				.orElseThrow(() -> new RuntimeException("User not found"));
		return resUser;
	}

}
