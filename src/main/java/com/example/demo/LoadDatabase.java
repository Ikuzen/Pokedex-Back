package com.example.demo;

import com.example.demo.model.Abilities;
import com.example.demo.model.Images;
import com.example.demo.model.Pokemon;
import com.example.demo.model.Stats;
import com.example.demo.model.Types;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PokemonRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(
                    new Pokemon("charmander",
                            new Types("fire"),
                            0.6f,
                            (float) 8.5,
                            new Abilities("solar-flare","fire"),
                            new Images("image1","image2"),
                            new Stats(10,20,10,10,20,10))));
            };
        };
}