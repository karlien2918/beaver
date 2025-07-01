package com.example.paymentservice.outbox.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestMessage {
	private final String message;

	public TestMessage(String message) {
		this.message = message;
	}
}
