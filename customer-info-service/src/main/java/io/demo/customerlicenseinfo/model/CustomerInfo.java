package io.demo.customerlicenseinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CustomerInfo {
    @Id
    private String id;
    private String customerName;
    private List<License> license;

    public CustomerInfo(){

    }
    public CustomerInfo(String customerName, List<License> license) {
        this.customerName = customerName;
        this.license = license;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<License> getLicense() {
        return license;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setLicense(List<License> license) {
        this.license = license;
    }
}
