package com.techtoha.chatsynchronizer.util;

import com.techtoha.chatsynchronizer.domain.Message;
import com.techtoha.chatsynchronizer.domain.MessengerPlatform;
import com.techtoha.chatsynchronizer.domain.telegram.TelegramMessage;
import com.techtoha.chatsynchronizer.domain.telegram.TelegramPhoto;
import com.techtoha.chatsynchronizer.domain.vk.VkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageConverter
{

    private VkApi vkService;
    private TelegramApi telegramService;

    // TODO: really think about how to handle plain pictures
    @Autowired
    public MessageConverter(VkApi vkService, TelegramApi telegramService)
    {
        this.vkService = vkService;
        this.telegramService = telegramService;
    }

    public Message convert(TelegramMessage message)
    {
        Message converted = new Message();

        Long messageId = message.getMessageId();
        Long chatId = message.getChat().getId();
        String text = message.getText();

        ArrayList<String > photoUrls = new ArrayList<>();
        message.getPhotos()
            .forEach(x -> { photoUrls.add(this.telegramService.downloadImage(x.getId())); });

        // TODO: add forwarding sources

        converted.setId(messageId);
        converted.setPlatform(MessengerPlatform.TELEGRAM);
        converted.setChatId(chatId);
        converted.setText(text);
        converted.setPhotoUrls(photoUrls);

        return converted;
    }

    public Message convert(VkMessage message)
    {
        Message converted = new Message();

        Long messageId = message.getId();
        Long chatId = message.getPeerId();
        String text = message.getText();

        ArrayList<String> photoUrls = new ArrayList<>();
        message.getAttachments().stream()
                .filter(x -> x.getType().equals("photo"))
                .forEach(x -> photoUrls.add(x.getPhoto().getHighestResPhoto().getUrl()));

        ArrayList<String> postUrls = new ArrayList<>();
        message.getAttachments().stream()
                .filter(x -> x.getType().equals("wall"))
                .forEach(x -> postUrls.add(x.getPost().getPostURL()));

        converted.setId(messageId);
        converted.setChatId(chatId);
        converted.setPlatform(MessengerPlatform.VK);
        converted.setPhotoUrls(photoUrls);
        converted.setPostUrls(postUrls);
        converted.setText(text);
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
