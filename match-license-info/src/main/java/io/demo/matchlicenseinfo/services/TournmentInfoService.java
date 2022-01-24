package io.demo.matchlicenseinfo.services;

import io.demo.matchlicenseinfo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TournmentInfoService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RestTemplate restTemplate;

    public UserMatches findLicensedMatches(String customerId){
        CustomerLicense customerLicense = restTemplate
                .getForObject("http://customer-license-info/getCustomerLicenseInfo/"
                        + customerId, CustomerLicense.class);
        List<Match> matches = new ArrayList<>();
        for(License license: customerLicense.getLicense()) {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(license.getTournmentId()));
            Tournament tournament = mongoTemplate.findOne(query, Tournament.class);
            if (license.getLicenseType().equalsIgnoreCase("Tournament")) {
                matches.addAll(tournament.getMatches());
            }else if (license.getLicenseType().equalsIgnoreCase("Match")) {
                List<Match> licensedMatch = tournament.getMatches().stream()
                        .filter(match-> match.getId().equalsIgnoreCase(license.getMatchId()))
                        .collect(Collectors.toList());
                matches.addAll(licensedMatch);
            }
        }
        UserMatches userMatches = new UserMatches();
        userMatches.setUserId(customerId);
        userMatches.setCustomerName(customerLicense.getCustomerName());
        userMatches.setMatches(matches);
        return userMatches;
    }

}
