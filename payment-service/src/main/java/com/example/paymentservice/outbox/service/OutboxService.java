package com.example.paymentservice.outbox.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OutboxService {

	public OutboxService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	private final KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "payment-events")
	public void listenPaymentEvents(String message) {
		System.out.println(message);
	}

	@KafkaListener(topics = "payment-events", groupId = "payment-group")
	public void sendMessage(String topic, String message) {
		kafkaTemplate.send("payment-events", message);
		System.out.println("Sent message: " + message);
	}
}
