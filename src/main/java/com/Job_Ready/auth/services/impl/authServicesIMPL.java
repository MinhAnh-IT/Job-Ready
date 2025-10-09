package com.Job_Ready.auth.services.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Job_Ready.auth.dtos.requests.LoginRequest;
import com.Job_Ready.auth.dtos.responses.TokenResponse;
import com.Job_Ready.auth.entities.Account;
import com.Job_Ready.auth.repositories.AccountRepository;
import com.Job_Ready.auth.services.authServices;
import com.Job_Ready.config.utills.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authServicesIMPL implements authServices {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final AccountRepository accountRepository;

	@Override
	public TokenResponse login(LoginRequest request) {
		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);

		Optional<Account> opt = accountRepository.findByUsername(request.getUsername());
		if (opt.isEmpty()) {
			throw new RuntimeException("User not found after authentication");
		}
		Account account = opt.get();

		String access = jwtService.generateAccessToken(account.getAccountId().toString(), account.getUsername(), account.getRole().name());
		String refresh = jwtService.generateRefreshToken(account.getAccountId().toString(), account.getRole().name());

		TokenResponse resp = new TokenResponse();
		resp.setAccessToken(access);
		resp.setRefreshToken(refresh);
		resp.setAccessExpiresIn(jwtService.getJwtExpiration());
		resp.setRefreshExpiresIn(jwtService.getJwtRefreshExpiration());
		return resp;
	}

	@Override
	public TokenResponse refreshToken(String refreshToken) {
		if (!jwtService.validateToken(refreshToken)) {
			throw new RuntimeException("Invalid refresh token");
		}
		String userId = jwtService.getUserIdFromJWT(refreshToken);
		Optional<Account> opt = accountRepository.findById(java.util.UUID.fromString(userId));
		if (opt.isEmpty()) {
			throw new RuntimeException("User not found");
		}
		Account account = opt.get();

		String access = jwtService.generateAccessToken(account.getAccountId().toString(), account.getUsername(), account.getRole().name());
		String refresh = jwtService.generateRefreshToken(account.getAccountId().toString(), account.getRole().name());

		TokenResponse resp = new TokenResponse();
		resp.setAccessToken(access);
		resp.setRefreshToken(refresh);
		resp.setAccessExpiresIn(jwtService.getJwtExpiration());
		resp.setRefreshExpiresIn(jwtService.getJwtRefreshExpiration());
		return resp;
	}
}
