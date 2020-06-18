package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.security.SecurityCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {
    final static Logger log = LoggerFactory.getLogger(MessageService.class);

    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Message> getMessage() {
        return repository.getMessage();
    }

    @SecurityCheck
    @Transactional(noRollbackFor = { UnsupportedOperationException.class })
    public Message save(String text) {
        Message msg = new Message(text);
        log.info("new Message(text) = " + msg);
        log.info("msg.id = " + msg.getId());
        log.info("msg.text = " + msg.getText());
        log.info("msg.getCreatedDate = " + msg.getCreatedDate());

        return repository.saveMessage(new Message(text));
    }
}
