package gr.aueb.cf.schoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages="gr.aueb.cf.schoolapp.repository")
public class SchoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAppApplication.class, args);
	}

}
