package com.rustdv.webconstruction.chat;

import com.rustdv.webconstruction.chat.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable("to") String to, MessageModel messageModel) {
        System.out.println("handling send message: " + messageModel + " to: " + to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, messageModel);
        }
    }
}
