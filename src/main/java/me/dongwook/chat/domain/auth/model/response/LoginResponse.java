package me.dongwook.chat.domain.auth.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import me.dongwook.chat.common.exception.ErrorCode;

@Schema(description = "user login 응답")
public record LoginResponse(

        @Schema(description = "error code")
        ErrorCode description,

        @Schema(description = "jwt token")
        String token

) {
}
