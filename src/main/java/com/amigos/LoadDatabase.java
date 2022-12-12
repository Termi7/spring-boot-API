package com.amigos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Customer(1, "thomas","hi@gmail.com)", 30)));
            log.info("Preloading " + repository.save(new Customer(2, "Jackson","jackson@gmail.com)", 35)));
            log.info("Preloading " + repository.save(new Customer(3, "thomas","thomas1@gmail.com)", 27)));
        };
    }
}