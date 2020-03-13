package com.techtoha.chatsynchronizer.routing;

import com.fasterxml.jackson.databind.JsonNode;
import com.techtoha.chatsynchronizer.domain.Message;
import com.techtoha.chatsynchronizer.util.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRouter
{

    private ChatRepository chatRepo;
    private MessageConverter converter;

    @Autowired
    public ChatRouter(ChatRepository chatRepo, MessageConverter converter)
    {
        this.chatRepo = chatRepo;
        this.converter = converter;
    }

    public void routeMessage(Message message)
    {

    }
}
