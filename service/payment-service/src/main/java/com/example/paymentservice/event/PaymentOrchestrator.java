package com.example.paymentservice.event;

import com.example.paymentservice.application.payment.dto.request.PaymentRequest;
import com.example.paymentservice.application.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentOrchestrator {

	private final PaymentService paymentService;
	public void createOrder(PaymentRequest request) {
		paymentService.pending(request);


		// 1. authorized
		// 2. captured


/*
	PENDING,	    //결제 요청이 접수되어 처리 대기 중
	AUTHORIZED,	    //결제 승인이 완료된 상태
	RECEIPTS,       //결제 영수증 확인
	CAPTURED,	    //실제 결제 금액이 확정,
	COMPLETED,      //결제 후, 상품 최종 지급 완료

*/
	}
}
