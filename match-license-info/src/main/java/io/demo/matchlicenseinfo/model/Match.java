package io.demo.matchlicenseinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document
public class Match {
    @Id
    private String id;
    private LocalDateTime startDate;
    private String playerA;
    private String playerB;

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

    public String getId() {
        return id;
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


}
