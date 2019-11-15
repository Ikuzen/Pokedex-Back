package com.example.demo;
import com.example.demo.model.Abilities;
import com.example.demo.model.Pokemon;
import com.example.demo.model.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findByName(String name);
    Pokemon findByNumber(int number);
    Pokemon findByAbilities(Abilities abilities);
    Pokemon findByTypes(Types type);
}