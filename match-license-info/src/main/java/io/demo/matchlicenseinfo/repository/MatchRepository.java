package io.demo.matchlicenseinfo.repository;

import io.demo.matchlicenseinfo.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match, String> {

}
