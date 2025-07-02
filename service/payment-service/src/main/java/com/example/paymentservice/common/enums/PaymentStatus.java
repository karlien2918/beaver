package com.example.paymentservice.common.enums;

public enum PaymentStatus {
	PENDING,	    //결제 요청이 접수되어 처리 대기 중
	AUTHORIZED,	    //결제 승인이 완료된 상태
	RECEIPTS,       //결제 영수증 확인
	CAPTURED,	    //실제 결제 금액이 확정,
	COMPLETED,      //결제 후, 상품 최종 지급 완료

	FAILED,	        //결제 승인 실패 또는 오류 발생
	CANCELED,	    //결제 취소 완료
	REFUNDED,	    //결제 금액이 환불 처리됨
	EXPIRED	        //결제 요청 유효 기간 만료
}
