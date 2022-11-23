package com.project;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.models.AppUser;
import com.project.models.Roles;
import com.project.services.UserService;

@SpringBootApplication
public class SpringbootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args->{
			userService.saveRole(new Roles("ROLE_USER"));
			userService.saveRole(new Roles("ROLE_MANAGER"));
			userService.saveRole(new Roles("ROLE_ADMIN"));
			userService.saveRole(new Roles("ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new AppUser("Gopalakrishnan","Cybertron","password",new ArrayList<>()));
			userService.saveUser(new AppUser("Michale Scott","littlekidlover","diejan",new ArrayList<>()));
			userService.saveUser(new AppUser("Dwight","bears","beats",new ArrayList<>()));
			userService.saveUser(new AppUser("Jim","rider","pam",new ArrayList<>()));
			
			userService.addRoleToUser("Cybertron", "ROLE_USER");
			userService.addRoleToUser("Cybertron", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("littlekidlover", "ROLE_ADMIN");
			userService.addRoleToUser("bears", "ROLE_USER");
			userService.addRoleToUser("bears", "ROLE_MANAGER");
			userService.addRoleToUser("rider", "ROLE_USER");
		};
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
