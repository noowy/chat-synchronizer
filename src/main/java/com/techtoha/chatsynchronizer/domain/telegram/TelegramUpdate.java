package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class TelegramUpdate
{

    @JsonProperty("update_id")
    private Integer updateId;

    @JsonProperty("message")
    private JsonNode message;

    @JsonProperty("edited_message")
    private JsonNode editedMessage;
}
