package com.imgarena.demo.services;

import com.imgarena.demo.model.Match;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Component
public class UserMatchService {

    public String getMatchSummary(String summaryType, Match match){
        if("AvB".equalsIgnoreCase(summaryType)){
            return match.getPlayerA() + " vs " + match.getPlayerB();
        }else if("AvBTime".equalsIgnoreCase(summaryType)){
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startDate = Optional.ofNullable(match).map(Match::getStartDate).orElse(null);
            Boolean isInFuture = Optional.ofNullable(startDate)
                    .map(startTime->startTime.isAfter(now)).orElse(true);
            LocalDate todaysDate = LocalDate.now();
            if(isInFuture){
                if(todaysDate.equals(startDate.toLocalDate())) {
                    Long minutes = ChronoUnit.MINUTES.between(now, startDate);
                    return "Starts in " +Math.abs(minutes)+ " minutes.";
                }else{
                    Long days = ChronoUnit.DAYS.between(now, startDate);
                    return "Starts in " +days+ " days.";
                }
            }else{
                if(todaysDate.equals(startDate.toLocalDate())) {
                    Long minutes = ChronoUnit.MINUTES.between(now, startDate);
                    return "Started " +Math.abs(minutes)+ " minutes ago.";
                }else{
                    Long days = ChronoUnit.DAYS.between(now, startDate);
                    return "Started " +days+ " days ago.";
                }
            }
        }
        return "Not applicable";
    }
}
