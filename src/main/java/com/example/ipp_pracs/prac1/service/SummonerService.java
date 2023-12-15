package com.example.ipp_pracs.prac1.service;

import com.example.ipp_pracs.prac1.dto.LeagueEntryDTO;
import com.example.ipp_pracs.prac1.dto.Summoner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;

@Component
public class SummonerService {
    @Value("${riot.api.key}")
    private String apiKey;


    private final ObjectMapper objectMapper = new ObjectMapper();

    public Summoner getSummonerData(String summonerName, String server) throws IOException, InterruptedException {
        String url = "https://" + server + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Riot-Token", apiKey) // Используйте apiKey из свойств
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Преобразование JSON-ответа в объект Summoner
        return objectMapper.readValue(response.body(), Summoner.class);
    }

    public List<LeagueEntryDTO> getSummonerRank(String summonerId, String server) throws IOException, InterruptedException {
        String url = "https://" + server + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Riot-Token", apiKey)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<List<LeagueEntryDTO>>() {});
    }



}
