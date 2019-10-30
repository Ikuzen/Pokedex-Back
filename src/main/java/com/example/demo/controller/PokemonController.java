package com.example.demo.controller;
import com.example.demo.exceptions.PokemonNameNotFoundException;
import com.example.demo.exceptions.PokemonNotFoundException;
import com.example.demo.PokemonRepository;
import com.example.demo.model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class PokemonController {

    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    ///
    // WEB SERVICES
    ///


    @GetMapping("/pokemons")
    List<Pokemon> getAllPokemon() {
        return repository.findAll();
    }

    @PostMapping("/pokemon")
    Pokemon createPokemon(@RequestBody Pokemon newPokemon) {
        return repository.save(newPokemon);
    }

    @GetMapping("/pokemon/{id}")
    Pokemon getPokemonById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }

//    @GetMapping("/pokemon/{name}")
//    Pokemon getPokemonByName(@PathVariable String name) {
//
//        return repository.findByName(name)
//                .orElseThrow(() -> new PokemonNameNotFoundException(name));
//    }

    @PutMapping("/pokemon")
    Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return repository.findById(pokemon.getId())
                .map(poke -> {
                    poke.setName(pokemon.getName());
                    poke.setTypes(pokemon.getTypes());
                    poke.setHeight(pokemon.getHeight());
                    poke.setWeight(pokemon.getWeight());
                    poke.setMoves(pokemon.getMoves());
                    poke.setImages(pokemon.getImages());
                    poke.setStats(pokemon.getStats());
                    return repository.save(poke);
                })
                .orElseGet(() -> {
                    pokemon.setId(pokemon.getId());
                    return repository.save(pokemon);
                });
    }

    @DeleteMapping("/pokemon/{id}")
    void deletePokemon(@PathVariable Long id) {
        repository.deleteById(id);
    }
}