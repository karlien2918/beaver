package com.example.keycloak.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties {
	private String serverUrl;
	private String serverAdminUrl;
	private String realm;
	private String clientId;
	private String clientSecret;
}