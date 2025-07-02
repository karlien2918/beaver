package com.example.paymentservice.application.payment.entity;

import com.example.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name ="trace_id")
	private String traceId;

	@Column
	private String status;

	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(name ="order_id", nullable = false, unique = true)
	private String orderId;

	@Column(nullable = false)
	private long price;

}
