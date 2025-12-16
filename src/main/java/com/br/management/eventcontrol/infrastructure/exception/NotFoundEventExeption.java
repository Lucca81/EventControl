package com.br.management.eventcontrol.infrastructure.exception;

public class NotFoundEventExeption extends RuntimeException {
    public NotFoundEventExeption(String message) {
        super(message);
    }
}
