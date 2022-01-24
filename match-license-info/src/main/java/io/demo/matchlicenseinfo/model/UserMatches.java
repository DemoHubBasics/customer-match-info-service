package io.demo.matchlicenseinfo.model;

import java.util.List;

public class UserMatches {
    private String userId;
    private String customerName;
    private List<Match> matches;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getUserId() {
        return userId;
    }

    public List<Match> getMatches() {
        return matches;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
