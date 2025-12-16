package com.br.management.eventcontrol.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handlerDuplicateEventException(DuplicateEventException eventException){
        Map<String, String> response = new HashMap<>();
        response.put("Error", eventException.getMessage());
        response.put("Message", "Please insert a valid hashId for your event try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handlerNotFoundEventException(NotFoundEventExeption notFoundException){
        Map<String, String> response = new HashMap<>();
        response.put("Error", notFoundException.getMessage());
        response.put("Message", "Please insert a existing hashId for your event try again");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handlerNotFoundEventExceptionIdentifier(EventExceptionIdentifierNotFound notFoundException){
        Map<String, String> response = new HashMap<>();
        response.put("Error", notFoundException.getMessage());
        response.put("Message", "Please enter an existing identifier for your event and try again.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
