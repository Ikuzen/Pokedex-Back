package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class PokemonController {

    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/pokemons")
    List<Pokemon> all() {
        return repository.findAll();
    }

    @PostMapping("/pokemons")
    Pokemon newPokemon(@RequestBody Pokemon newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/pokemons/{id}")
    Pokemon one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }

    @PutMapping("/pokemons/{id}")
    Pokemon replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {

        return repository.findById(id)
                .map(pokemon -> {
                    pokemon.setName(newPokemon.getName());
                    return repository.save(pokemon);
                })
                .orElseGet(() -> {
                    newPokemon.setId(id);
                    return repository.save(newPokemon);
                });
    }

    @DeleteMapping("/pokemons/{id}")
    void deletePokemon(@PathVariable Long id) {
        repository.deleteById(id);
    }
}