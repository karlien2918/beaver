package com.example.paymentservice.outbox.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record OutboxMessage(

		@NotBlank(message = "Not found id")
		Long id,

		@Email(message = "Invalid email")
		String email,

		@NotBlank(message = "Invalid message type")
		String messageType) {

}
