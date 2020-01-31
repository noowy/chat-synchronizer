package com.techtoha.chatsynchronizer.receivers.telegram;

import com.techtoha.chatsynchronizer.config.TelegramConfig;
import com.techtoha.chatsynchronizer.domain.telegram.TelegramUpdate;
import com.techtoha.chatsynchronizer.routing.ChatRouter;
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

    @Autowired
    public TelegramReceiveController(TelegramConfig conf, ChatRouter router)
    {
        this.conf = conf;
        this.router = router;
    }

    @PostMapping("/new_message")
    public String handleNewMessage(@RequestBody TelegramUpdate update)
    {
        if (!update.getMessage().isNull())
            log.info(update.getMessage().toPrettyString());

        return "ok";
    }
}
