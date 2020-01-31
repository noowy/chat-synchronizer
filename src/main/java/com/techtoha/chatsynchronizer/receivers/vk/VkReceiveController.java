package com.techtoha.chatsynchronizer.receivers.vk;

import com.fasterxml.jackson.databind.JsonNode;
import com.techtoha.chatsynchronizer.config.VkConfig;
import com.techtoha.chatsynchronizer.domain.vk.VkEvent;
import com.techtoha.chatsynchronizer.routing.ChatRouter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vk")
public class VkReceiveController
{

    private VkConfig conf;
    private ChatRouter router;

    @Autowired
    public VkReceiveController(VkConfig conf, ChatRouter router)
    {
        this.conf = conf;
        this.router = router;
    }

    @PostMapping("/new_message")
    public String handleNewMessage(@RequestBody VkEvent event)
    {
        if (!event.getSecret().equals(conf.SECRET))
            return "uidi otsuda pidor gryaznii";

        if (event.getType().equals("confirmation"))
            return conf.CONFIRMATION_TOKEN;

        if (event.getType().equals("message_new"))
            router.routeMessage("Vk", event.getObject());

        return "ok";
    }
}
