package com.base.webSocket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket // 웹소켓 서버를 활성화하는 어노테이션
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        /*
          웹소켓 핸들러를 등록하는 메소드
          첫 번째 인자 : 웹소켓 핸들러
          두 번째 인자 : 웹소켓 핸들러의 URL 매핑
          setAllowedOrigins("*") : 모든 도메인에서 접근 가능하도록 설정
          withSockJS() : SockJS를 사용하도록 설정
         */
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}

