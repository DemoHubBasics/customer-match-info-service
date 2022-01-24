package io.demo.customerlicenseinfo.repository;

import io.demo.customerlicenseinfo.model.CustomerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerInfoRepository extends MongoRepository<CustomerInfo, String> {

}
