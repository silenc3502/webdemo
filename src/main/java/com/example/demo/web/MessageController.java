package com.example.demo.web;

import com.example.demo.entity.Message;
import com.example.demo.request.MessageData;
import com.example.demo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {
    static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public String index() {
        return "vueIndex";
    }

    @GetMapping("/messages/welcome")
    public String welcome(Model model) {
        model.addAttribute("message",
                "Hello, Vue-Spring-MySQL-Python-WebGL");
        return "welcome";
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<List<Message>> getMessage() {
        log.info("Get /api/messages");
        List<Message> messages = messageService.getMessage();
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
        log.info("Post /api/messages");
        log.info("data = " + data.getText());

        Message saved = messageService.save(data.getText());

        if(saved == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(saved);
    }
}
