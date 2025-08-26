package com.lin.booking.util.common;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final Key key = Keys.hmacShaKeyFor(CommonConstant.API_SECRET_KEY.getBytes());

	public static String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuer("BookingApp").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + CommonConstant.TOKEN_EXPIRATION))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public static String validateToken(String token) {
		try {
			Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

			return claimsJws.getBody().getSubject();
		} catch (JwtException e) {
			return null;
		}
	}

	public static void main(String[] args) {
//		String token = JwtUtil.generateToken("linn");
//		System.out.println(token);
		String result = JwtUtil.validateToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsaW5uIiwiaXNzIjoiQm9va2luZ0FwcCIsImlhdCI6MTc1NjE3NzgxOCwiZXhwIjoxNzU2MTc3ODc4fQ.sYGqrrKv_M8sq4_DKyJPYm29VFtqfnFEHWDe95uQMaY");
		System.out.println("valid? " + result);
	}
}
