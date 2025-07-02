package com.example.paymentservice.application.payment.mapper;


import com.example.paymentservice.application.payment.dto.request.OrderCreateRequest;
import com.example.paymentservice.application.payment.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
	Payment toEntity(OrderCreateRequest request);
}
