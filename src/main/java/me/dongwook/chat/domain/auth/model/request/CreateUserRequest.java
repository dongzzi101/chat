package me.dongwook.chat.domain.auth.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

@Schema(description = "user 생성")
public record CreateUserRequest(

        @Schema(description = "유저 이름")
        @NotBlank
        @NonNull
        String name,

        @Schema(description = "유저 비밀번호")
        String password
) {
}

