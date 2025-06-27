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
		try {

			System.out.println("분산락 시작 ");

			//0. 결제 정보 생성 및 Payment Id 정보 생성
			System.out.println("save payment Ok.");

			System.out.println("outbox 메시지 전달 :: kafka - uid, payment id? 상태값");
		}catch (Exception e){
			//실패케이스로 캔슬처리도 메시지로;
		}finally {
			System.out.println("락 해제");
		}

	}
}

