package com.example;

/**
 * Created by Oana on 3/4/2017.
 * this is a custom exception
 */
public class ExceptionForAthlete extends RuntimeException {
    public ExceptionForAthlete(String message) {
        super(message);
    }
}
