package com.example.paymentservice.utils;


import java.util.UUID;

public class UuidUtils {

	public static String generator(){
		final UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
