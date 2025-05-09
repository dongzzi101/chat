package me.dongwook.chat.domain.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dongwook.chat.domain.auth.model.request.CreateUserRequest;
import me.dongwook.chat.domain.auth.model.response.CreateUserResponse;
import me.dongwook.chat.domain.repository.UserRepository;
import me.dongwook.chat.domain.repository.entity.User;
import me.dongwook.chat.domain.repository.entity.UserCredentials;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional(transactionManager = "createUserTransactionManager")
    public CreateUserResponse createUser(CreateUserRequest request) {
        Optional<User> user = userRepository.findByName(request.name());

        if (user.isPresent()) {
            // TODO error
        }

        try {
            User newUser = newUser(request.name());
            UserCredentials userCredentials = new UserCredentials(newUser, request.password());
            newUser.setCredentials(userCredentials);

            User savedUser = userRepository.save(newUser);
            if (savedUser == null) {
                // TODO error
            }

        } catch (Exception e) {
            // TODO error
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
        // TODO hash
    }


}
