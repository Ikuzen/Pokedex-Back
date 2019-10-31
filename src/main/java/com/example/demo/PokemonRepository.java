package com.example.demo;
import com.example.demo.model.Abilities;
import com.example.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findByName(String name);
    List<Pokemon> findByAbilities(Abilities abilities);
}