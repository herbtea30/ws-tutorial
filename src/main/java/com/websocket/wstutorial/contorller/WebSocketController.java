package com.websocket.wstutorial.contorller;

import com.websocket.wstutorial.dto.Message;
import com.websocket.wstutorial.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebSocketController {

    private final WebSocketService webSocketService;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
       webSocketService.notifyFrontend(message.getMessageContent());
    }
}