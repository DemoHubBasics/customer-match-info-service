package io.demo.customerlicenseserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CustomerLicenseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLicenseServerApplication.class, args);
	}

}
