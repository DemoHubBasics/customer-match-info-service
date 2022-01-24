package io.demo.matchlicenseinfo.controller;

import io.demo.matchlicenseinfo.model.*;
import io.demo.matchlicenseinfo.services.TournmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/matchInfo")
public class MatchInfoController {

    @Autowired
    TournmentInfoService tournmentInfoService;

    @RequestMapping("/{customerId}")
    public UserMatches getMatches(@PathVariable("customerId") String customerId){
        return tournmentInfoService.findLicensedMatches(customerId);
    }

}
