package com.example.paymentservice.application.payment.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentRequest {

	@NotBlank(message = "The user id is required.")
	private String userId;

	@NotBlank(message = "The product is required.")
	private String productId;

	@NotNull(message = "The product amount is required.")
	@DecimalMin(value = "0.01", message = "Invalid amount.")
	private BigDecimal amount;

}
