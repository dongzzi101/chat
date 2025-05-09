package me.dongwook.chat.domain.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dongwook.chat.common.exception.CustomException;
import me.dongwook.chat.common.exception.ErrorCode;
import me.dongwook.chat.domain.auth.model.request.CreateUserRequest;
import me.dongwook.chat.domain.auth.model.request.LoginRequest;
import me.dongwook.chat.domain.auth.model.response.CreateUserResponse;
import me.dongwook.chat.domain.auth.model.response.LoginResponse;
import me.dongwook.chat.domain.repository.UserRepository;
import me.dongwook.chat.domain.repository.entity.User;
import me.dongwook.chat.domain.repository.entity.UserCredentials;
import me.dongwook.chat.security.Hasher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final Hasher hasher;

    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByName(loginRequest.name());

        if (!user.isPresent()) {
            log.error("No such user: {}", loginRequest.name());
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        user.map(u -> {
            String hashingValue = hasher.getHashingValue(loginRequest.password());

            if (!u.getUserCredentials().getHashed_password().equals(hashingValue)) {
                throw new CustomException(ErrorCode.MISS_MATCH_PASSWORD);
            }

            return hashingValue;
        }).orElseThrow(() -> {
            throw new CustomException(ErrorCode.MISS_MATCH_PASSWORD);
        });

        // TODO jwt
        return new LoginResponse(ErrorCode.SUCCESS, "TOKEN");
    }

    @Transactional(transactionManager = "createUserTransactionManager")
    public CreateUserResponse createUser(CreateUserRequest request) {
        Optional<User> user = userRepository.findByName(request.name());

        if (user.isPresent()) {
            log.error("User {} already exists", request.name());
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST, "User already exists");
        }

        try {
            User newUser = newUser(request.name());
            UserCredentials userCredentials = new UserCredentials(newUser, request.password());
            newUser.setCredentials(userCredentials);

            User savedUser = userRepository.save(newUser);
            if (savedUser == null) {
                throw new CustomException(ErrorCode.USER_SAVED_FAILED);
            }

        } catch (Exception e) {
            throw new CustomException(ErrorCode.USER_SAVED_FAILED);
        }

        return new CreateUserResponse(request.name());
    }

    private User newUser(String name) {
        return User.builder()
                .name(name)
                .created_at(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    private UserCredentials newUserCredentials(User user, String password) {
        String hashingValue = hasher.getHashingValue(password);

        return UserCredentials.builder()
                .user(user)
                .hashed_password(hashingValue)
                .build();
    }


}
