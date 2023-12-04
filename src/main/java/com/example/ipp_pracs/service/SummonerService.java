package com.example.ipp_pracs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class SummonerService {
    @Value("${riot.api.key}")
    private String apiKey;

    public void send(String summonerName) throws IOException, InterruptedException {
        String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Riot-Token", "RGAPI-94c73b24-2a06-46dc-b0c7-824f41bf5972")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
