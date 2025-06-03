package com.example.flightapi.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.config.BaseResponse;
import com.example.flightapi.dto.UserRequestDTO;
import com.example.flightapi.dto.UserResponseDTO;
import com.example.flightapi.entity.User;
import com.example.flightapi.service.UserService;
import com.example.flightapi.util.UserMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // 临时处理跨域问题（开发阶段）
@Tag(name = "Auth API", description = "APIs for Auth Check")
@Validated
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserMapper userMapper;

	@PostMapping("/createUser")
	public BaseResponse<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
		User user = userMapper.toEntity(dto);
		User saved = userService.createUser(user);
		if (saved == null) {
			String msg = messageSource.getMessage("user.create_failed", null, Locale.ENGLISH);
			return BaseResponse.failure(400, msg);
		}
		UserResponseDTO responseDTO = userMapper.toResponseDTO(saved);
		return BaseResponse.success(responseDTO);
	}

	@PostMapping("/login")
	public BaseResponse<UserResponseDTO> userLogin(@RequestBody UserRequestDTO dto) {
		User resUser = userService.userLogin(userMapper.toEntity(dto));
		if (resUser == null) {
			String msg = messageSource.getMessage("user.not_found", null, Locale.ENGLISH);
			return BaseResponse.failure(401, msg);
		}
		UserResponseDTO responseDTO = userMapper.toResponseDTO(resUser);
		return BaseResponse.success(responseDTO);
	}
}
