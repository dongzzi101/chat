package me.dongwook.chat.domain.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dongwook.chat.domain.auth.model.request.CreateUserRequest;
import me.dongwook.chat.domain.auth.model.request.LoginRequest;
import me.dongwook.chat.domain.auth.model.response.CreateUserResponse;
import me.dongwook.chat.domain.auth.model.response.LoginResponse;
import me.dongwook.chat.domain.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

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

    @Operation(
            summary = "로그인 처리",
            description = "로그인을 진행합니다."
    )
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }

    @Operation(
            summary = "get user name",
            description = "get user name from token"
    )
    @PostMapping("/get-user-name/{token}")
    public String getUserFromToken(@PathVariable String token) {
        return authService.getUserFormToken(token);
    }
}
