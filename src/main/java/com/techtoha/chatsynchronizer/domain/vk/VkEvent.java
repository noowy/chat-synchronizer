package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class VkEvent
{

    @JsonProperty("type")
    private String type;

    @JsonProperty("object")
    private JsonNode object;

    @JsonProperty("group_id")
    private Long groupId;

    @JsonProperty("secret")
    private String secret;
}
