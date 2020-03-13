package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.List;

@Data
public class VkMessage
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("date")
    private Long date;

    @JsonProperty("peer_id")
    private Long peerId;

    @JsonProperty("from_id")
    private Long fromId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("random_id")
    private Long randomId;

    @JsonProperty("attachments")
    private List<VkAttachment> attachments;

    @JsonProperty("important")
    private Boolean important;

    @JsonProperty("fwd_messages")
    private List<VkMessage> fwdMessages;

    @JsonProperty("action")
    private JsonNode action;

}
