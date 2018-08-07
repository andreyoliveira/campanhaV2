package br.com.conceptmx.campanhaV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"br.com.conceptmx.campanhaV2.model"
})
@EnableJpaRepositories(basePackages = {
		"br.com.conceptmx.campanhaV2.repository"
})
public class CampanhaV2Application {

	public static void main(String[] args) {
		SpringApplication.run(CampanhaV2Application.class, args);
	}
}
