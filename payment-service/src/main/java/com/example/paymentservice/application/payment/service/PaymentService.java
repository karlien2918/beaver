package com.example.paymentservice.application.payment.service;

import com.example.paymentservice.application.payment.dto.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final ApplicationEventPublisher publisher;

	//TODO @Trancaction
	public void pending(PaymentRequest request) {
		//0. 결제 정보 생성 및 Payment Id 정보 생성
		System.out.println("pending ok");

		//생성해서 저장
	}
}

