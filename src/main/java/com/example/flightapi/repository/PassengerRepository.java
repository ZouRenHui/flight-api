package com.example.flightapi.repository;

import com.example.flightapi.entity.Passenger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	List<Passenger> findByUserId(Integer userId);
}
