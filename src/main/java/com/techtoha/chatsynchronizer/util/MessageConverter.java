package com.techtoha.chatsynchronizer.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.techtoha.chatsynchronizer.domain.Message;
import com.techtoha.chatsynchronizer.domain.MessengerPlatform;
import com.techtoha.chatsynchronizer.domain.telegram.TelegramMessage;
import com.techtoha.chatsynchronizer.domain.vk.VkAttachment;
import com.techtoha.chatsynchronizer.domain.vk.VkMessage;
import com.techtoha.chatsynchronizer.domain.vk.VkPhotoSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

@Service
public class MessageConverter
{

    private VkLookupService vkService;

    // TODO: really think about how to handle plain pictures
    @Autowired
    public MessageConverter(VkLookupService vkService)
    {
        this.vkService = vkService;

    }

    public Message convert(TelegramMessage message)
    {
        Message converted = new Message();

        // TODO: CHECK ALL THE REFERENCES OF JSON NODES
        converted.setId(message.getMessageId());
        converted.setPlatform(MessengerPlatform.TELEGRAM);
        converted.setChatId(message.getChat().get("chat_id").asLong());
        converted.setText(message.getText());

        if (!message.getForwardFrom().isNull())
            converted.setForwardSource(message.getForwardFrom().get("name").asText());
        if (!message.getForwardFromChat().isNull())
            converted.setForwardSource("Chat " + message.getForwardFromChat().get("name").asText());
        if (!message.getPhoto().isNull())
        {

        }


        return converted;
    }

    public Message convert(VkMessage message)
    {
        Message converted = new Message();

        converted.setId(message.getId());
        converted.setChatId(message.getPeerId());
        converted.setPlatform(MessengerPlatform.VK);

        ArrayList<String> photoUrls = new ArrayList<>();
        message.getAttachments().stream()
                .filter(x -> x.getType().equals("photo"))
                .forEach(x -> photoUrls.add(x.getPhoto().getHighestResPhoto().getUrl()));

        ArrayList<String> postUrls = new ArrayList<>();
        message.getAttachments().stream()
                .filter(x -> x.getType().equals("wall"))
                .forEach(x -> postUrls.add(x.getPost().getPostURL()));

        converted.setPhotoUrls(photoUrls);
        converted.setPostUrls(postUrls);
        converted.setText(message.getText());
        converted.setFrom(vkService.getUserFullName(message.getFromId()));
        // TODO: add forwarding sources

        return converted;
    }

    public VkMessage convertToVk(Message message)
    {
        VkMessage converted = new VkMessage();

        return converted;
    }

    public TelegramMessage convertToTelegram(Message message)
    {
        TelegramMessage converted = new TelegramMessage();

        return converted;
    }
}
