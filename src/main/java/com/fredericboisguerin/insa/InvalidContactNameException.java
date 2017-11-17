package com.fredericboisguerin.insa;

public class InvalidContactNameException extends Exception {
    public InvalidContactNameException() {
    }

    public InvalidContactNameException(String name) {
        super(name);
    }
}
