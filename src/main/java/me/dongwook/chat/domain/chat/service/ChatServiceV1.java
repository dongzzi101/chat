package me.dongwook.chat.domain.chat.service;

import lombok.RequiredArgsConstructor;
import me.dongwook.chat.domain.chat.model.Message;
import me.dongwook.chat.domain.repository.ChatRepository;
import me.dongwook.chat.domain.repository.entity.Chat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ChatServiceV1 {

    private final ChatRepository chatRepository;

    @Transactional(transactionManager = "createChatTransactionManager")
    public void saveChatMessage(Message msg) {
        Chat chat = Chat.builder()
                .sender(msg.getFrom())
                .receiver(msg.getTo())
                .message(msg.getMessage())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        chatRepository.save(chat);
    }


}
