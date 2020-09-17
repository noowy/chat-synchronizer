package com.techtoha.chatsynchronizer.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.techtoha.chatsynchronizer.config.VkConfig;
import com.techtoha.chatsynchronizer.domain.vk.VkMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class VkApi
{

    private RestTemplate rest;
    private VkConfig conf;

    @Autowired
    public VkApi(RestTemplate rest, VkConfig conf)
    {
        this.rest = rest;
        this.conf = conf;
    }

    public String getUserFullName(Long id)
    {
        return "Name";
    }

    public String sendMessage(VkMessage message)
    {
        return "sent";
    }

    private JsonNode callMethod(String method, Object params)
    {
        String requestPoint = this.conf.API_ENDPOINT + "/" + method;

        Map<String, String> serviceParams = new HashMap<>();
        serviceParams.put("v", this.conf.VK_API_VERSION);
        serviceParams.put("access_token", this.conf.VK_ACCESS_TOKEN);

        ResponseEntity<JsonNode> response = rest.exchange(
                requestPoint,
                HttpMethod.GET,
                null,
                JsonNode.class, // TODO: don't leave it like this, make a vk error wrapper
                params,
                serviceParams
        );
        log.info(response.toString());

        return response.getBody();
    }
}
