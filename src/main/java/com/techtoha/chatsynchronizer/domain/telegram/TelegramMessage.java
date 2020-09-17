package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.List;

@Data
public class TelegramMessage
{

    @JsonProperty("message_id")
    private Long messageId;

    private JsonNode from;

    private Integer date;

    private TelegramChat chat;

    @JsonProperty("forward_from")
    private TelegramUser forwardFrom;

    @JsonProperty("forward_from_chat")
    private TelegramChat forwardFromChat;

    private String text;

    private JsonNode audio;

    private JsonNode animation;

    private List<TelegramPhoto> photos;
}
