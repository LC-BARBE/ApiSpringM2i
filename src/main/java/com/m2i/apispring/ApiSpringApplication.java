package com.m2i.apispring;

import com.m2i.apispring.Service.JsonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ApiSpringApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ApiSpringApplication.class, args);

        JsonService.getSongByJsonFile();

    }

}
