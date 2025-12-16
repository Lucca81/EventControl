package com.br.management.eventcontrol.infrastructure.exception;

public class DuplicateEventException extends RuntimeException {
    public DuplicateEventException(String message) {
        super(message);
    }
}
