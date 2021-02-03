package fr.da2i.flooz.controllers;

import fr.da2i.flooz.model.Message;
import fr.da2i.flooz.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/public/message/{name}")
    public Message getMessage(@PathVariable String name) {
        return messageRepository.findById(name).orElse(new Message("Error", "Error"));
    }

}
