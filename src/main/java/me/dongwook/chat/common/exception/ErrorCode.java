package me.dongwook.chat.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements CodeInterface {
    SUCCESS(0, "SUCCESS"),

    USER_ALREADY_EXIST(-1, "ALREADY_EXIST"),
    USER_SAVED_FAILED(-2, "USER_SAVED_FAILED"),
    USER_NOT_FOUND(-3, "USER_NOT_FOUND"),
    MISS_MATCH_PASSWORD(-4, "MISS_MATCH_PASSWORD"),

    TOKEN_IS_INVALID(-200, "TOKEN_IS_INVALID"),
    ACCESS_TOKEN_IS_NOT_EXPIRED(-201, "ACCESS_TOKEN_IS_NOT_EXPIRED"),
    TOKEN_IS_EXPIRED(-202, "TOKEN_IS_EXPIRED");



    private final Integer code;
    private final String message;


}
