package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Member {
    private String userName = "sdr4linux";
    private String password = "123456";

    // Date 타입의 들어오는 정보가
    // 아래 Annotation에 pattern 걸린 형태대로 들어와야 한다.
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date myDate;

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
