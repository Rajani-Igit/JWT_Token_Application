package com.jwtsecurity.sample.controller;

import java.util.Date;
import java.util.HashMap;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

public class Test {
	
	public static void main(String[] args) {
		// Sample test Application
		HashMap<String,Object> mp=	new HashMap<String,Object>();
		mp.put("rajni","kant");
       // DefaultClaims claims=new DefaultClaims();
  
		String jwt = 
			    Jwts.builder().setIssuer("http://trustyapp.com/").setClaims(mp)
			        .setSubject("users/1300819380")
			        .setExpiration(new Date(2017,12,20))
			        .signWith(SignatureAlgorithm.HS256,"secure")
			        .compact();
		System.out.println(jwt);
		Jws jwtClaims = Jwts.parser().setSigningKey("secure").parseClaimsJws(jwt);
		//System.out.println(jwtClaims.getBody());
		DefaultClaims claims=((DefaultClaims) jwtClaims.getBody());
		System.out.println(claims.containsKey("rajni"));
		System.out.println(claims.get("rajni"));

	}

}
