package com.example.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
public class JwtAuthConverterConfig {

	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter(){
		JwtGrantedAuthoritiesConverter authConverter = new JwtGrantedAuthoritiesConverter();
		authConverter.setAuthorityPrefix("ROLE_");
		authConverter.setAuthoritiesClaimName("realm_access.roles");

		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(authConverter);
		return converter;
	}
}
