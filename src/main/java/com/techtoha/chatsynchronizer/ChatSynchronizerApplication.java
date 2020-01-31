package com.techtoha.chatsynchronizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ChatSynchronizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatSynchronizerApplication.class, args);
	}

}
