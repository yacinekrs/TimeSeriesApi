package com.TimeSeries.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class TimeSeriesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeSeriesApiApplication.class, args);
	}

}
