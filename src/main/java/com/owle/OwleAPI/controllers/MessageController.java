package com.owle.OwleAPI.controllers;

import com.owle.OwleAPI.model.Message;
import com.owle.OwleAPI.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/public/message/{name}")
    public @ResponseBody
    Message getMessage(@PathVariable String name){
        return messageRepository.findById(name).orElse(new Message("Error", "Error"));
    }

}
