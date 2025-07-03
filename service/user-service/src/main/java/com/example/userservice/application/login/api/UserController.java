package com.example.userservice.application.login.api;

import com.example.userservice.application.login.dto.request.UserRegisterRequest;
import com.example.userservice.application.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController(UserController.ENDPOINT_PREFIX)
public class UserController {

	public static final String ENDPOINT_PREFIX = "user";

	private final UserService userService;

	@PostMapping(value ="/register")
	public ResponseEntity<String> register(@RequestBody UserRegisterRequest request){

		userService.register(request);
		return new ResponseEntity<>("token", HttpStatus.OK);

	}

}
