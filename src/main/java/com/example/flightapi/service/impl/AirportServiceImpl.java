package com.example.flightapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flightapi.entity.Airport;
import com.example.flightapi.repository.AirportRepository;
import com.example.flightapi.service.AirportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;


    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll()
                .stream()
                .toList();
    }

}
