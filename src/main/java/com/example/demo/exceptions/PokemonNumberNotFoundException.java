package com.example.demo.exceptions;

public class PokemonNumberNotFoundException extends RuntimeException {
    public PokemonNumberNotFoundException(int number) {
        super("Could not find Pokemon number " + number);
    }
}
