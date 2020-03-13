package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class TelegramMessage
{

    @JsonProperty("message_id")
    private Long messageId;

    private JsonNode from;

    private Integer date;

    private JsonNode chat;

    @JsonProperty("forward_from")
    private JsonNode forwardFrom;

    @JsonProperty("forward_from_chat")
    private JsonNode forwardFromChat;

    private String text;

    private JsonNode audio;

    private JsonNode animation;

    private JsonNode photo;
}
