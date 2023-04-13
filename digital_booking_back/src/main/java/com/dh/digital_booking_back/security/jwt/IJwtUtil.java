package com.dh.digital_booking_back.security.jwt;

import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;

public interface IJwtUtil {

    String extractUserName(String token);

    Date extractExpiration(String token);

    Date extractClaimDate(String token);

    String extractClaimUsername(String token);

    Claims extractAllClaims(String token);

    String generateToken(UserDetails userDetails) throws ResourceNotFoundException;

    String createToken(Map<String, Object> claims, String subject);

    Boolean validateToken(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

}
