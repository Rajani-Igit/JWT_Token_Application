package com.jwtsecurity.sample.controller;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

@Controller
public class MapApikeyGenController {
	@RequestMapping(value = "/keygen", method = RequestMethod.GET)
	@ResponseBody
	public String generateKey(@RequestParam(value = "email") String email) {
		String jws = Jwts.builder().setIssuer("Rajanikanta").setSubject("Ascessing for Services").claim("uid", email)
				.claim("scope", "user")
				.setIssuedAt(new Date(2017,12,8))
				.setExpiration(new Date(2018,12,10))
				.signWith(SignatureAlgorithm.HS256, "secretekey").compact();
		return jws;

	}

	@RequestMapping(value="/validatetoken",method=RequestMethod.POST)
	@ResponseBody
	public String validateToken(@RequestParam("token") String token){
		System.out.println("token " +token);
		DefaultClaims claims=null;
		String message = "unknown exception,Generate new token";
			Jws jwtClaims = Jwts.parser().setSigningKey("secretekey").parseClaimsJws(token);
		//System.out.println(jwtClaims.getBody());
		 claims=((DefaultClaims) jwtClaims.getBody());
		 if(claims.get("uid").equals("rajanikanta.pradhan5@gmail.com")){
			 message= "You have permission to access";
			 return message;
			}
			else
				message= "you do not have permession to access";
		 return message;

		
		
		
	}
	

	}
