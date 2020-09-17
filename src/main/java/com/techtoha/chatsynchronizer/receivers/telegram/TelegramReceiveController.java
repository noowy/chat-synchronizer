package com.techtoha.chatsynchronizer.receivers.telegram;

import com.techtoha.chatsynchronizer.config.TelegramConfig;
import com.techtoha.chatsynchronizer.domain.telegram.TelegramUpdate;
import com.techtoha.chatsynchronizer.routing.ChatRouter;
import com.techtoha.chatsynchronizer.util.MessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/telegram")
public class TelegramReceiveController
{

    private TelegramConfig conf;
    private ChatRouter router;
    private MessageConverter converter;

    @Autowired
    public TelegramReceiveController(TelegramConfig conf, ChatRouter router, MessageConverter converter)
    {
        this.conf = conf;
        this.router = router;
        this.converter = converter;
    }

    @PostMapping("/new_message")
    public String handleNewMessage(@RequestBody TelegramUpdate update)
    {
        if (update.getMessage() != null)
            log.info(update.getMessage().toString());
        if (update.getEditedMessage() != null)
            log.info(update.getEditedMessage().toString());

        return "ok";
    }
}
