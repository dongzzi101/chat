package me.dongwook.chat.domain.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dongwook.chat.domain.auth.model.request.CreateUserRequest;
import me.dongwook.chat.domain.auth.model.response.CreateUserResponse;
import me.dongwook.chat.domain.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth API", description = "V1 Auth API")
public class AuthControllerV1 {

    private final AuthService authService;

    @Operation(
            summary = "새로운 유저를 생성",
            description = "새로운 유저 생성"
    )
    @PostMapping("/create-user")
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) {
        return authService.createUser(request);
    }


}
