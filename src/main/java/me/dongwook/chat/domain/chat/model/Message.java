package me.dongwook.chat.domain.chat.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String to;
    private String from;
    private String message;
}
