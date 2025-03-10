package com.HMSA.Hospital.Management.System;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {

		Dotenv dot = Dotenv.load();

		String dbUrl= dot.get("DB_URL");
		String dbDatabase = dot.get("DB_DATABASE");

		System.out.println("DB_URL: " + dbUrl);
		System.out.println("DB_DATABASE: " + dbDatabase);

		System.setProperty("DB_URL", dbUrl);
		System.setProperty("DB_DATABASE", dbDatabase);


		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

}
