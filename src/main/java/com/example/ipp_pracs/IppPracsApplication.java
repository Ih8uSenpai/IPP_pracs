package com.example.ipp_pracs;

import com.example.ipp_pracs.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
public class IppPracsApplication {
    public static void main(String[] args) {
        SpringApplication.run(IppPracsApplication.class, args);
    }
}