package me.dongwook.chat.domain.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dongwook.chat.domain.auth.model.request.CreateUserRequest;
import me.dongwook.chat.domain.auth.model.response.CreateUserResponse;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {


    public CreateUserResponse createUser(CreateUserRequest request) {
        return new CreateUserResponse(request.name());
    }
}
