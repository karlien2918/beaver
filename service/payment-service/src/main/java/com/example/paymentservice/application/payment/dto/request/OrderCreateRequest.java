package com.example.paymentservice.application.payment.dto.request;

import java.math.BigDecimal;

public record OrderCreateRequest(

		String userId,

		String productId,

		BigDecimal amount,

		String type
		) {}
