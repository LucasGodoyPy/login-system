package com.lucas_login.Login;

import com.lucas_login.Login.entity.User;
import com.lucas_login.Login.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication {

	@Bean
	public CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("admin") == null) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole("ADMIN");
				userRepository.save(admin);
				System.out.println("Admin creado");
			}

			if (userRepository.findByUsername("usuario") == null) {
				User user = new User();
				user.setUsername("usuario");
				user.setPassword(passwordEncoder.encode("user123"));
				user.setRole("USER");
				userRepository.save(user);
				System.out.println("Usuario creado");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
