package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message save(String text) {
        return repository.saveMessage(new Message(text));
    }
}
