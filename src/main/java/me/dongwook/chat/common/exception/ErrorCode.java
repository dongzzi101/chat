package me.dongwook.chat.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements CodeInterface {
    SUCCESS(0, "SUCCESS"),

    USER_ALREADY_EXIST(-1, "ALREADY_EXIST"),
    USER_SAVED_FAILED(-2, "USER_SAVED_FAILED");


    private final Integer code;
    private final String message;


}
