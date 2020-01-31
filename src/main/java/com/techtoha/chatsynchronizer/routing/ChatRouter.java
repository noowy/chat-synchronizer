package com.techtoha.chatsynchronizer.routing;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public class ChatRouter
{
    private ChatRepository chatRepo;

    public void routeMessage(String platform, JsonNode message)
    {

    }
}
