package com.example.libraryeventcon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryEventConApplication {

    public static void main (String[] args) {
        SpringApplication.run(LibraryEventConApplication.class, args);
    }

    @Bean
    public ObjectMapper getObjectMapper ( ) {
        return new ObjectMapper();
    }

}
