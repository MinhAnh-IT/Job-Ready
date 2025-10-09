package com.Job_Ready.auth.services;

import com.Job_Ready.auth.dtos.requests.LoginRequest;
import com.Job_Ready.auth.dtos.responses.TokenResponse;

public interface authServices {
	TokenResponse login(LoginRequest request);
	TokenResponse refreshToken(String refreshToken);
}
