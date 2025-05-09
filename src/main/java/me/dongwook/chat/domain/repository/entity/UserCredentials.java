package me.dongwook.chat.domain.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Table(name = "user")
public class UserCredentials {

    @Id
    @OneToOne
    @JoinColumn(name = "user_t_id")
    private User user;

    @Column(nullable = false)     // not null
    private String hashed_password;


}
