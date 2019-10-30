package com.example.demo;
import com.example.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByName(String name);
}