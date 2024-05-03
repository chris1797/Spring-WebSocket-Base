package com.base.webSocket.config;

import com.base.webSocket.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;



    // 목적 : 웹소켓 연결이 성공하면 호출되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.warn("CONNECT");
        super.afterConnectionEstablished(session);
    }

    // 목적 : 웹소켓 클라이언트로부터 메시지가 도착하면 호출되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}", payload);

    }

    private void sendMessage(Set<WebSocketSession> session, String message) {
            // 병렬 스트림을 사용하여 각 세션에 메시지를 전송
            session.parallelStream().forEach(roomSession -> {
                try {
                    roomSession.sendMessage(new TextMessage(message));
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.warn("DISCONNECT");
        super.afterConnectionClosed(session, status);
    }


}
