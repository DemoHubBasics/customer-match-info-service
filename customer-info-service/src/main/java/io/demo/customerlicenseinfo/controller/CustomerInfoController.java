package io.demo.customerlicenseinfo.controller;

import io.demo.customerlicenseinfo.model.CustomerInfo;
import io.demo.customerlicenseinfo.model.CustomerLicense;
import io.demo.customerlicenseinfo.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("getCustomerLicenseInfo")
public class CustomerInfoController {

    @Autowired
    protected CustomerInfoService customerInfoService;
    @RequestMapping("/{customerId}")
    public CustomerLicense getCustomerLicense(@PathVariable("customerId") String customerId){
        CustomerInfo customer = customerInfoService.findByCustomerLicense(customerId);
        return new CustomerLicense(customer.getId(),
                customer.getCustomerName(), customer.getLicense());

    }
}
