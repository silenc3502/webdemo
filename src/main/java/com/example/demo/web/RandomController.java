package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    static Random rand = new Random();
    static Logger logger = LoggerFactory.getLogger(RandomController.class);

    // private RandNumService randNumService;
    @GetMapping("/random")
    public int getRandom() {
        return rand.nextInt(32) + 1;
    }
}
