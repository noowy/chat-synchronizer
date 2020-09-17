package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TelegramUpdate
{

    @JsonProperty("update_id")
    private Integer updateId;

    @JsonProperty("message")
    private TelegramMessage message;

    @JsonProperty("edited_message")
    private TelegramMessage editedMessage;
}
