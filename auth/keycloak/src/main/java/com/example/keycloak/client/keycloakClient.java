package com.example.keycloak.client;

import com.example.keycloak.config.KeycloakConfig;
import org.springframework.stereotype.Service;

@Service
public class keycloakClient {

	private KeycloakConfig keycloakConfig;


	//사용자 생성 (관리자 API)
	//Endpoint:
	//POST /admin/realms/{realm}/users

	//4. 사용자 비활성화 (관리자 API)
	//Endpoint:
	//PUT /admin/realms/{realm}/users/{id}

	//5. 사용자 정보 조회
	//Endpoint:
	//GET /admin/realms/{realm}/users/{id}

	//2. 토큰 발급 (로그인), 3. Refresh 토큰 갱신
	//Endpoint:
	//POST /realms/{realm}/protocol/openid-connect/token


	//6. 토큰 유효성 검사 (Introspection)
	//Endpoint:
	//POST /realms/{realm}/protocol/openid-connect/token/introspect

}
