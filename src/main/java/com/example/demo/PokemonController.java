package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class PokemonController {

    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pokemons")
    List<Pokemon> getAllPokemon() {
        return repository.findAll();
    }

    @PostMapping("/pokemon")
    Pokemon createPokemon(@RequestBody Pokemon newPokemon) {
        return repository.save(newPokemon);
    }

    @GetMapping("/pokemons/{id}")
    Pokemon one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }


    @PutMapping("/pokemon")
    Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return repository.findById(pokemon.getId())
                .map(poke -> {
                    poke.setName(pokemon.getName());
                    return repository.save(poke);
                })
                .orElseGet(() -> {
                    pokemon.setId(pokemon.getId());
                    return repository.save(pokemon);
                });
    }

    @DeleteMapping("/pokemons/{id}")
    void deletePokemon(@PathVariable Long id) {
        repository.deleteById(id);
    }
}