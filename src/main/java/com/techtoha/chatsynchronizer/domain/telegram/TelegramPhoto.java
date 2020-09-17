package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TelegramPhoto
{

    @JsonProperty("file_id")
    private String id;
}
