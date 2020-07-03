package com.ashi.tech.projectspringsecurity;

import com.ashi.tech.projectspringsecurity.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@EnableJpaRepositories(basePackages = "")
public class ProjectSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringSecurityApplication.class, args);
	}

}
