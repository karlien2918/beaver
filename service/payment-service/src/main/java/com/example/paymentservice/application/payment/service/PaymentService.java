package com.example.paymentservice.application.payment.service;

import com.example.paymentservice.application.payment.dto.request.OrderCreateRequest;
import com.example.paymentservice.application.payment.dto.request.PaymentRequest;
import com.example.paymentservice.application.payment.mapper.PaymentMapper;
import com.example.paymentservice.application.payment.repository.PaymentRepository;
import com.example.paymentservice.outbox.service.OutboxPublisher;
import com.example.paymentservice.utils.UuidUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentMapper paymentMapper;
	private final PaymentRepository paymentRepository;
	private final OutboxPublisher outboxPublisher;


	@Transactional
	public void pending(PaymentRequest request) {
		try {

			//TODO 분산락
			final String orderUuid = UuidUtils.generator();


			//유효한 상품인지
			//유저 정보 결제

			OrderCreateRequest orderRequest = new OrderCreateRequest(null, null, null, null);
			paymentRepository.save(paymentMapper.toEntity(orderRequest));



			System.out.println("outbox 메시지 전달 :: kafka - uid, payment id? 상태값");
			System.out.println("return ok");
		} catch (Exception e){
			//실패케이스로 캔슬처리도 메시지로;
		} finally {
			System.out.println("락 해제");
		}
	}
}

