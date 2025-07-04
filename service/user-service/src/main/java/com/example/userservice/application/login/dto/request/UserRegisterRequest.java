package com.example.userservice.application.login.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(
		@Email(message = "Invalid email")
		@NotBlank(message = "is empty email")
		String email,

		@NotBlank
		String password,

		@NotBlank
		String processType) {


}
