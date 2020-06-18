package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Message {
    private Integer id;
    private String text;
    private Date createdDate;

    public Message(String text) {
        this.text = text;
    }

    public Message(Integer id, String text, Date createdDate) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
