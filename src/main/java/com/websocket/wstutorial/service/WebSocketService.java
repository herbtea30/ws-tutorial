package com.websocket.wstutorial.service;

import com.websocket.wstutorial.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void notifyFrontend(final String message) {
        ResponseMessage response = new ResponseMessage(message);

        simpMessagingTemplate.convertAndSend("/topic/messages", response);
    }

}