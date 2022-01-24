package io.demo.matchlicenseinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class License {
    @Id
    private String id;
    private String licenseType;
    private String tournmentId;
    private String matchId;

    public License(){

    }

    public License(String licenseType, String tournmentId, String matchId) {
        this.licenseType = licenseType;
        this.tournmentId = tournmentId;
        this.matchId = matchId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setTournmentId(String tournmentId) {
        this.tournmentId = tournmentId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getId() {
        return id;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getTournmentId() {
        return tournmentId;
    }

    public String getMatchId() {
        return matchId;
    }
}
