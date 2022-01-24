package io.demo.customerlicenseinfo.services;

import io.demo.customerlicenseinfo.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerInfoService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RestTemplate restTemplate;

    public CustomerInfo findByCustomerLicense(String customerId){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(customerId));
        CustomerInfo customerInfo =  mongoTemplate.findOne(query, CustomerInfo.class);
        return customerInfo;
    }
}
