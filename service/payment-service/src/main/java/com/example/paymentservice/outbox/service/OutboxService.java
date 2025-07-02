package com.example.paymentservice.outbox.service;

import com.example.paymentservice.outbox.dto.request.OutboxMessage;
import com.example.paymentservice.outbox.entity.Outbox;
import com.example.paymentservice.outbox.mapper.OutBoxMapper;
import com.example.paymentservice.outbox.repository.OutBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutboxService {

	private final OutBoxMapper outBoxMapper;
	private final OutBoxRepository outBoxRepository;
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

	public OutboxMessage sendOutBoxMapperTest(String email){
		final Outbox outbox = outBoxRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not found outbox data"));
		return outBoxMapper.toMessage(outbox);
	}

}
