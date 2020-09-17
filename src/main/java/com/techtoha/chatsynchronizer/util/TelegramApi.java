package com.techtoha.chatsynchronizer.util;

import com.techtoha.chatsynchronizer.config.TelegramConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TelegramApi
{

    private RestTemplate rest;
    private TelegramConfig conf;

    @Autowired
    public TelegramApi(RestTemplate rest, TelegramConfig conf)
    {
        this.rest = rest;
        this.conf = conf;
    }

    public String downloadImage(String imageId)
    {
        return "link";
    }

    public byte[] getImage(String imageId)
    {
        return new byte[0];
    }

    private Object callMethod(String method, Object params)
    {

        return "nice";
    }
}
