package com.example.paymentservice.outbox.api;

import com.example.paymentservice.outbox.service.OutboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OutBoxTestController {

	private final OutboxService outboxService;

	@PostMapping("/outbox/test-send")
	public ResponseEntity<String> testSend(@RequestBody TestMessage request){
		outboxService.sendMessage("payment-events", request.getMessage());

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
