package com.techtoha.chatsynchronizer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("com.techtoha.chatsynchronizer.config.vk")
@Data
@Configuration
public class VkConfig
{

    public String CONFIRMATION_TOKEN;
    public String API_ENDPOINT;
    public String SECRET;
    public String VK_API_VERSION;
    public String VK_ACCESS_TOKEN;
}
