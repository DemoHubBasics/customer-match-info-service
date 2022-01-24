package com.imgarena.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class Tournament {
    private String id;
    private String tournamentId;
    private List<Match> matches;

    public Tournament(){

    }
    public Tournament(String tournamentId, List<Match> matches) {
        this.tournamentId = tournamentId;
        this.matches = matches;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
