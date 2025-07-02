/*
package com.example.jwt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.List;


public class JwtTokenProvider {


	//토큰 생성
	public String generatorToken(String userId, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(userId);
		claims.put("roles", roles);

		Date now = Date.from(Instant.now());
		Date expireDate = new Date(now.getTime() + accessTokenValidityMs);

		return Jwts.builder()
				.setClaims(claims)
				//TODO
				.claim("email", "karlien@naver.com")
				.claim("displayName", "beaver")
				.claim("provider", "google")
				.setIssuedAt(now)
				.setExpiration(expireDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}


	public String getUserId(String token){
		return parseClaims(token).getSubject();
	}

	//토큰 유효성 검사
	public List<String> getRoles(String token){

		//TODO 나중에 유틸화
		ObjectMapper objectMapper = new ObjectMapper();
		Object rolesObject = parseClaims(token).get("roles");
		return objectMapper.convertValue(rolesObject, new TypeReference<List<String>>(){});
	}

	public String getEmail(String token){
		return parseClaims(token).get("email").toString();
	}

	private Claims parseClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

}
*/
