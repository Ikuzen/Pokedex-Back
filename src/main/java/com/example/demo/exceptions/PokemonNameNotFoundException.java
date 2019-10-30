package com.example.demo.exceptions;

public class PokemonNameNotFoundException extends RuntimeException {
    public PokemonNameNotFoundException(String name) {
        super("Could not find Pokemon " + name);
    }
}