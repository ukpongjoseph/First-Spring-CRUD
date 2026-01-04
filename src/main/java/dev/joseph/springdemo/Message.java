package dev.joseph.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Message {
    public String getMessage(){
        return "hello world";
    }
}
