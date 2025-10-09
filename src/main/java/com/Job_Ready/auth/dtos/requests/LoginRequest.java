package com.Job_Ready.auth.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class LoginRequest {
    String username;
    String password;
}
