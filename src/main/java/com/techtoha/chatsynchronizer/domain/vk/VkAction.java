package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkAction
{

    @JsonProperty("type")
    private String type;

    @JsonProperty("member_id")
    private Integer memberId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("email")
    private String email;

    @JsonProperty("photo")
    private VkPhoto photo;
}
