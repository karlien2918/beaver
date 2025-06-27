package com.example.paymentservice.application.payment.api;

import com.example.paymentservice.common.models.response.ApiResponse;
import com.example.paymentservice.event.PaymentOrchestrator;
import com.example.paymentservice.application.payment.dto.request.PaymentRequest;
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

	/**
	 * 모든 요청 로그는 AOP에서 처리
	 * @param request
	 * @return
	 */

	@PostMapping("/payment")
	public ResponseEntity<ApiResponse<Void>> payment(@RequestBody @Valid PaymentRequest request){
		paymentOrchestrator.pending(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
