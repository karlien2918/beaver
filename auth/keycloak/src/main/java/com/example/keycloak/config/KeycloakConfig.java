package com.example.keycloak.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KeycloakConfig {
	private final String serverUrl;
	private final String serverAdminUrl;
	private final String realm;
	private final String clientId;
	private final String clientSecret;

	public KeycloakConfig(KeycloakProperties prop) {
		this.serverUrl = prop.getServerUrl();
		this.serverAdminUrl = prop.getServerAdminUrl();
		this.realm = prop.getRealm();
		this.clientId = prop.getClientId();
		this.clientSecret = prop.getClientSecret();
	}

	//TODO 더 필요하다면 URL 구분되는 것은 추가로 미리 만들어놓는게 좋을 듯

}
