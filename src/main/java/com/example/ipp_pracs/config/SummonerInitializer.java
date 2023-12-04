package com.example.ipp_pracs.config;

import com.example.ipp_pracs.service.SummonerService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SummonerInitializer {

    private final SummonerService summonerService;

    public SummonerInitializer(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String summonerName = "lady%20gaga%20jg%20acc";
        try {
            summonerService.send(summonerName);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}