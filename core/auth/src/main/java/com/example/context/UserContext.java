package com.example.context;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class UserContext {

	public static String getUserId(){
		return getJwt().getSubject();
	}

	public static String getEmail(){
		return getJwt().getClaim("email");
	}

	private static Jwt getJwt(){
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !(authentication.getPrincipal() instanceof Jwt jwt)) {
			throw new IllegalStateException("Not found Jwt");
		}

		return jwt;
	}
}
