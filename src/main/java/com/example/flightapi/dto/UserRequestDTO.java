package com.example.flightapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
	@NotBlank(message = "{user.email.required}")
	private String email;
	@NotBlank(message = "{user.password.required}")
	private String password;
	private String firstName;
	private String lastName;
	private Integer gender;
	private String country;
	private String phone;
}