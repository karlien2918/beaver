package com.example.configration;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	/* TODO 차후 추가
	private final AwsSecretsManagerUtil secretsUtil;
	private final ObjectMapper objectMapper;
	*/
	@Bean
	public DataSource dataSource() throws Exception {
		/*
		//TODO 차후 연결
		String secretJson = secretsUtil.getSecret("my-db-secret");
		JsonNode node = objectMapper.readTree(secretJson);

		String username = node.get("username").asText();
		String password = node.get("password").asText();
		//지금은 다이렉트로
		*/
		return DataSourceBuilder.create()
				.url("jdbc:postgresql://localhost:5432/beaver-user-db")
				.username("admin")
				.password("1234")
				.build();
	}

}
