package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PokemonNameNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PokemonNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pokemonNameNotFoundHandler(PokemonNameNotFoundException ex) {
        return ex.getMessage();
    }
}