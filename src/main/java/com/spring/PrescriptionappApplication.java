package com.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@SpringBootApplication
public class PrescriptionappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionappApplication.class, args);
	}

	@Bean
	CommandLineRunner initDefaultUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("admin") == null) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin")); // encode password
				userRepository.save(admin);
				System.out.println("Default admin user created: username=admin, password=admin");
			}
		};
	}

}
