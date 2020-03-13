package com.techtoha.chatsynchronizer.domain;

import lombok.Data;

import java.util.List;

@Data
public class Message
{
    private Long id;

    private String from;

    private String forwardSource;

    private String text;

    private List<String> photoUrls;

    private List<byte[]> photos;

    private List<String> postUrls;

    private Long chatId;

    private MessengerPlatform platform;

}
