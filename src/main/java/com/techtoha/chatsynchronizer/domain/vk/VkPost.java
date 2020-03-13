package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkPost
{

    @JsonProperty("id")
    private Long postId;

    @JsonProperty("owner_id") // may change to to_id
    private Long postSource;

    public String getPostURL()
    {
        return "https://vk.com/wall" + postSource.toString() + "_" + postId.toString();
    }
}
