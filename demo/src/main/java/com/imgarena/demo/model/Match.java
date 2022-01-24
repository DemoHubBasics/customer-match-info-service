package com.imgarena.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


public class Match {

    private String id;
    private LocalDateTime startDate;
    private String playerA;
    private String playerB;
    private String summary;

    public Match() {
    }

    public Match(LocalDateTime startDate, String playerA, String playerB) {
        this.startDate = startDate;
        this.playerA = playerA;
        this.playerB = playerB;
    }



    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setPlayerA(String playerA) {
        this.playerA = playerA;
    }

    public void setPlayerB(String playerB) {
        this.playerB = playerB;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public String getPlayerA() {
        return playerA;
    }

    public String getPlayerB() {
        return playerB;
    }
    public String getId() {
        return id;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }



}
