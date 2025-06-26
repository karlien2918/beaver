package com.example.paymentservice.payment.api;

import com.example.paymentservice.common.models.response.ApiResponse;
import com.example.paymentservice.orchestrator.PaymentOrchestrator;
import com.example.paymentservice.payment.dto.request.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaymentController {

	private final PaymentOrchestrator paymentOrchestrator;

	@PostMapping("/payment")
	public ResponseEntity<ApiResponse<Void>> payment(@RequestBody @Valid PaymentRequest request){
		paymentOrchestrator.orchestration(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
