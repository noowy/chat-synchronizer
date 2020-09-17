package com.techtoha.chatsynchronizer.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TelegramUser
{

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String username;

    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }
}
