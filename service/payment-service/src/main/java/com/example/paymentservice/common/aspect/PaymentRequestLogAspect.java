package com.example.paymentservice.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PaymentRequestLogAspect {

	@Around("@within(org.springframework.web.bind.annotation.RestController) && execution(* com.example.paymentservice.payment.api..*(..))")
	//@Around("execution(* com.example.paymentservice.payment.api.*(..))")
	public Object paymentRequestLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Payment request log Ok");
		return joinPoint.proceed();
	}
}
