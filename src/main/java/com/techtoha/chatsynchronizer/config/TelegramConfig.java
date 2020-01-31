package com.techtoha.chatsynchronizer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("com.techtoha.chatsynchronizer.config.telegram")
@Data
public class TelegramConfig
{

    public String API_ENDPOINT;
}
