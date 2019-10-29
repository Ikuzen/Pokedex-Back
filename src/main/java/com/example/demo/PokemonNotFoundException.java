package com.example.demo;

public class PokemonNotFoundException extends RuntimeException {
    PokemonNotFoundException(Long id) {
        super("Could not find Pokemon " + id);
    }
}


