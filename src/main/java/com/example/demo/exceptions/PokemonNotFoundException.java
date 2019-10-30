package com.example.demo.exceptions;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(Long id) {
        super("Could not find Pokemon " + id);
    }
}


