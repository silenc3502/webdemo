package com.example.demo.entity;

import java.util.Random;

public class RandNumMessage {
    static Random rand = new Random();
    private Integer randNumber;

    public RandNumMessage() {
        this.randNumber = rand.nextInt(32) + 1;
    }

    public Integer getRandNumber() {
        return randNumber;
    }
}
