package com.example.ipp_pracs.controllers;

import com.example.ipp_pracs.prac1.dto.LeagueEntryDTO;
import com.example.ipp_pracs.prac1.dto.Summoner;
import com.example.ipp_pracs.prac1.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class PracticeController {

    @Autowired
    SummonerService summonerService;

    @GetMapping("/practice{number}")
    public ModelAndView showPractice(@PathVariable("number") int number) {
        if (number < 1 || number > 8) {
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("prac" + number);
    }

    @GetMapping("practice1/{server}/{summoner}")
    public ResponseEntity<Summoner> getSummoner(@PathVariable("server") String server, @PathVariable("summoner") String summoner) throws IOException, InterruptedException {
        Summoner summonerData = summonerService.getSummonerData(summoner, server); // Измените метод send на getSummonerData или подобный
        return ResponseEntity.ok(summonerData);
    }
    @GetMapping("practice1/{server}/{summonerId}/entries")
    public ResponseEntity<List<LeagueEntryDTO>> getSummonerEntries(@PathVariable("server") String server, @PathVariable("summonerId") String summonerId) throws IOException, InterruptedException {
        System.out.println(summonerId + "\n" + server);
        List<LeagueEntryDTO> summonerData = summonerService.getSummonerRank(summonerId, server);
        return ResponseEntity.ok(summonerData);
    }
}