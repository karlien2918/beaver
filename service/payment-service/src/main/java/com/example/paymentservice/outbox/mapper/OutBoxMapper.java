package com.example.paymentservice.outbox.mapper;


import com.example.paymentservice.outbox.dto.request.OutboxMessage;
import com.example.paymentservice.outbox.entity.Outbox;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OutBoxMapper {
	@Mapping(source = "id", target = "id")
	@Mapping(source = "email", target = "email")
	OutboxMessage toMessage(Outbox outbox);
}
