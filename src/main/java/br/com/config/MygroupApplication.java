package br.com.config;

import br.com.api.controllers.HomeController;
import br.com.api.repositories.AdministradorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = HomeController.class)
@EnableJpaRepositories(basePackageClasses = AdministradorRepository.class)
@EntityScan("br.com.*")
@EnableAutoConfiguration
public class MygroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MygroupApplication.class, args);
        System.out.println("FIM CARREGAMENTO");
    }
}
