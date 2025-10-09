package com.Job_Ready.auth.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class TokenResponse {
    String accessToken;
    String refreshToken;
    long accessExpiresIn;
    long refreshExpiresIn;
}
