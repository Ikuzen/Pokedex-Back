package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PokemonRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Pokemon("charmander", new String[]{"fire"}, 0.6f, (float) 8.5,new String[]{"solar-power","blaze"}, "imageUrl", new int[]{1, 2,3,4,5,6})));
        };
    }
}