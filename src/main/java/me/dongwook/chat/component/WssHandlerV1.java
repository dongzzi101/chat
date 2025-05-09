package me.dongwook.chat.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.dongwook.chat.domain.chat.model.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class WssHandlerV1 extends TextWebSocketHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage msg) throws Exception {

        try {
            String payload = msg.getPayload();
            Message message = objectMapper.readValue(payload, Message.class);

            // 1. db에 있는 데이터 인지
            // 2. 채팅 메시지 데이터 저장

            session.sendMessage(new TextMessage(payload));
        } catch (Exception e) {

        }
    }
}
