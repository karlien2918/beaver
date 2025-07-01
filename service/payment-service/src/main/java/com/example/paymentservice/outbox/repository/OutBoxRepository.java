package com.example.paymentservice.outbox.repository;


import com.example.paymentservice.outbox.entity.Outbox;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutBoxRepository extends JpaRepository<Outbox, Long> {
	Optional<Outbox> findByEmail(String email);
}