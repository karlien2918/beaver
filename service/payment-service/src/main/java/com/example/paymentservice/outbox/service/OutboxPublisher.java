package com.example.paymentservice.outbox.service;

import com.example.paymentservice.outbox.dto.request.OutboxMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OutboxPublisher{


	@Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))


	public void publishMessage(OutboxMessage message) {
	/*	kafkaTemplate.send("payment-topic", message.getPayload());
		message.markAsSent();
		outboxRepository.save(message);*/
	}
}
