package com.HMSA.Hospital.Management.System;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {

		// Check if we are in a production environment
		String env = System.getenv("ENVIRONMENT");

		String dbUrl;
		String dbDatabase;

		if (env == null || !env.equals("production")) {
			// In development, load environment variables from .env file
			Dotenv dotenv = Dotenv.load();
			dbUrl = dotenv.get("DB_URL");
			dbDatabase = dotenv.get("DB_DATABASE");
		} else {
			// In production, load environment variables directly from the system environment
			dbUrl = System.getenv("DB_URL");
			dbDatabase = System.getenv("DB_DATABASE");
		}

		// Optionally print the variables for debugging purposes
		System.out.println("DB_URL: " + dbUrl);
		System.out.println("DB_DATABASE: " + dbDatabase);

		// Set system properties for Spring Boot (useful if Spring uses them)
		System.setProperty("DB_URL", dbUrl);
		System.setProperty("DB_DATABASE", dbDatabase);

		// Run Spring Boot application
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
}
