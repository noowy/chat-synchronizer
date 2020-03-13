package com.techtoha.chatsynchronizer.util;

import com.techtoha.chatsynchronizer.config.VkConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class VkLookupService
{

    private RestTemplate rest;
    private VkConfig conf;

    @Autowired
    public VkLookupService(RestTemplate rest, VkConfig conf)
    {
        this.rest = rest;
        this.conf = conf;
    }

    public String getUserFullName(Long id)
    {
        return "Name";
    }
}
