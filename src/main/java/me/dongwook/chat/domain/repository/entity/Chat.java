package me.dongwook.chat.domain.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "t_id")
    private Long TID;

    private String sender;

    private String receiver;

    private String message;

    private Timestamp createdAt;
}
