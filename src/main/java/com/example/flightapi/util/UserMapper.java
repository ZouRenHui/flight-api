package com.example.flightapi.util;

import org.springframework.stereotype.Component;

import com.example.flightapi.dto.UserRequestDTO;
import com.example.flightapi.dto.UserResponseDTO;
import com.example.flightapi.entity.User;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
    	if (dto == null)
    		return null;
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .country(dto.getCountry())
                .phone(dto.getPhone())
                .build();
    }

    public UserResponseDTO toResponseDTO(User user) {
    	if (user == null)
    		return null;
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .country(user.getCountry())
                .phone(user.getPhone())
                .build();
    }
}
