package com.upgrad.hirewheels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HireWheelsApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(HireWheelsApplication.class, args);
	}

	@Override
	public void run(String... arg0){
	}
}
