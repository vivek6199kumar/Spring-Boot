package com.demo.boot.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String secret = "secret123";

	// 6. validate username in token and database ,expDate
	public boolean validateToken(String token, String username) {
		String tokenUserName = getUsername(token);
		return (username.equals(tokenUserName)) && !isTokenExp(token);

	}

	// 5. Validate Expire Date
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}

	// 4. Read subject/username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	// 3. Read Expire Date
	public Date getExpDate(String token) {

		return getClaims(token).getExpiration();

	}

	// 2. Read Claims(Read Token)
	public Claims getClaims(String token) {
		return Jwts
				.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();

	}

	// 1. Generate Token
	public String generateToken(String subject) {

		System.out.println("****************************** this is timeUnit :" + TimeUnit.MINUTES.toMillis(15));
		return Jwts
				.builder()
				.setSubject(subject) // prepare the object for subject is a username
				.setIssuer("vivek")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS256, secret).compact();

	}

}
