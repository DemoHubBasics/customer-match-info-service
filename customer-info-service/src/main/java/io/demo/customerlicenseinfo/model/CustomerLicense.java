package io.demo.customerlicenseinfo.model;


import java.util.List;

public class CustomerLicense {
    private String userId;
    private String customerName;
    List<License> license;

    public CustomerLicense(String userId, String customerName, List<License> license) {
        this.userId = userId;
        this.customerName = customerName;
        this.license = license;
    }


    public List<License> getLicense() {
        return license;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setLicense(List<License> license) {
        this.license = license;
    }

}
