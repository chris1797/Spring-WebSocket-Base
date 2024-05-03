package com.base.webSocket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {

    private String roomId;
    private String writer;
    private String message;
    private String timestamp;
}
