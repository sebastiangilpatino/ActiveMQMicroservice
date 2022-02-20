package com.example.bookreceiver.Service;

import com.example.bookreceiver.Model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BookMessageListener {

    @Autowired
    private ObjectMapper objectMapper;

    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String bookString) {
        try {
            Book book = objectMapper.readValue(bookString, Book.class);
            System.out.println("JMS received " + book);
        } catch (IOException e) {
            System.out.println("problems " + e);
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
