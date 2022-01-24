package com.imgarena.demo.controller;

import com.imgarena.demo.model.Match;
import com.imgarena.demo.model.UserMatches;
import com.imgarena.demo.services.UserMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/getMatches")
public class MatchCataLogController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMatchService userMatchService;

    @RequestMapping("/{customerId}")
    public UserMatches getMatches(@PathVariable("customerId") String customerId,
                                  @RequestParam(required = false, name="summaryType") String summaryType){

        UserMatches userMatches = restTemplate.getForObject("http://match-info-service/matchInfo/"
                + customerId, UserMatches.class);
                    userMatches.getMatches().stream().map(match -> {
                        String summary = userMatchService.getMatchSummary(summaryType, match);
                        match.setSummary(summary);
                        return match;
                    }).collect(Collectors.toList());
        return  userMatches;
    }
}
