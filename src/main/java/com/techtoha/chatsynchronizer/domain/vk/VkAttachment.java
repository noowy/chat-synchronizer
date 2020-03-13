package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkAttachment
{

    private String type;

    private VkPhoto photo;

    @JsonProperty("wall")
    private VkPost post;
}
