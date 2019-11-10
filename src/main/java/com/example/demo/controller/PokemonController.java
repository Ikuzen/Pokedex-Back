package com.example.demo.controller;
import com.example.demo.exceptions.PokemonNameNotFoundException;
import com.example.demo.exceptions.PokemonNotFoundException;
import com.example.demo.PokemonRepository;
import com.example.demo.exceptions.PokemonNumberNotFoundException;
import com.example.demo.model.Abilities;
import com.example.demo.model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class PokemonController {

    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials= "true", methods = {RequestMethod.GET, RequestMethod.DELETE,RequestMethod.POST, RequestMethod.PUT}, maxAge=3600)


    ///
    // WEB SERVICES
    ///

    //
    // GET
    //
    @GetMapping("/pokemons")
    List<Pokemon> getAllPokemon() {
        return repository.findAll();
    }


    @GetMapping("/pokemon/{id}")
    Pokemon getPokemonById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }
    @GetMapping("/pokemon/number/{number}")
    Pokemon getPokemonByNumber(@PathVariable int number) {

        return repository.findByNumber(number);
    }

    @GetMapping("/pokemon/name/{name}")
    Pokemon getPokemonByName(@PathVariable String name) {

        return repository.findByName(name);

    }

    @GetMapping("/abilities/{abilities}")
    Pokemon getPokemonAbilities(@PathVariable String abilities) {
        return repository.findByAbilities(new Abilities(abilities));
    }

    //
    // POST
    //
    @PostMapping("/pokemon")
    Pokemon createPokemon(@RequestBody Pokemon newPokemon) {
        return repository.save(newPokemon);
    }

    //
    // PUT
    //
    @PutMapping("/pokemon")
    Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return repository.findById(pokemon.getId())
                .map(poke -> {
                    poke.setName(pokemon.getName());
                    poke.setTypes(pokemon.getTypes());
                    poke.setHeight(pokemon.getHeight());
                    poke.setWeight(pokemon.getWeight());
                    poke.setAbilities(pokemon.getAbilities());
                    poke.setImages(pokemon.getImages());
                    poke.setStats(pokemon.getStats());
                    return repository.save(poke);
                })
                .orElseGet(() -> {
                    pokemon.setId(pokemon.getId());
                    return repository.save(pokemon);
                });
    }

    //
    // DELETE
    //
    @DeleteMapping("/pokemon/{id}")
    void deletePokemon(@PathVariable Long id) {
        repository.deleteById(id);
    }
}