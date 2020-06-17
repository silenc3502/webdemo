package com.example.demo.repository;

import com.example.demo.entity.RandNumMessage;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandNumRepository {

    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}
