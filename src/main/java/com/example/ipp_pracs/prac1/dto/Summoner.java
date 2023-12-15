package com.example.ipp_pracs.prac1.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class Summoner {

    String accountId;
    int profileIconId;
    long revisionDate;
    String name;
    String id;
    String puuid;
    long summonerLevel;
}
