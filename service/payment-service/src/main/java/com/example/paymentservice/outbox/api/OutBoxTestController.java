package com.example.paymentservice.outbox.api;

import com.example.context.UserContext;
import com.example.paymentservice.outbox.dto.request.OutboxMessage;
import com.example.paymentservice.outbox.service.OutboxService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/outbox/test-mapper")
	public ResponseEntity<OutboxMessage> testMapper(String email){
		final OutboxMessage message = outboxService.sendOutBoxMapperTest(email);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	@GetMapping("/me")
	public ResponseEntity<?> getMyProfile() {
		String userId = UserContext.getUserId();

		return ResponseEntity.ok(Map.of(
				"userId", userId
		));
	}
}
