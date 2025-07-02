package com.example.paymentservice.common.exception;

import com.example.paymentservice.application.payment.exception.PaymentFailedException;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handlePaymentFailedException(PaymentFailedException ex) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Payment Failed",
				ex.getMessage()

		);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Getter
	@Builder
	private static class ErrorResponse {
		private int status;
		private String error;
		private String message;
	}
}
