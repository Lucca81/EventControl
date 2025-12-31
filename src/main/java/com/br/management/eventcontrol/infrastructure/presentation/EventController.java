package com.br.management.eventcontrol.infrastructure.presentation;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.usecases.*;
import com.br.management.eventcontrol.infrastructure.gateway.EventRepositoryGateway;
import com.br.management.eventcontrol.infrastructure.mapper.EventDtoMapper;
import com.br.management.eventcontrol.infrastructure.reponse.EventResponseDto;
import com.br.management.eventcontrol.infrastructure.request.EventRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

    private final DeleteEventByIdUsecase deleteEventById;
    private final FilterIdentifierEventUsecase filterIdentifier;
    private final UpdateEventByIdUsecase updateEventById;
    private final FindEventByIdUsecase findEventById;
    private final ListEventUsecase listEvent;
    private final CreateEventUsecase createEvent;
    private final EventDtoMapper eventDtoMapper;
    private final EventRepositoryGateway eventRepositoryGateway;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        Event newEvent = createEvent.execute(eventDtoMapper.toDomain(eventRequestDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event created successfully ");
        response.put("Data List: ", eventDtoMapper.toResponse(newEvent));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listEvent() {
        List<EventResponseDto> list = listEvent.execute().
                stream()
                .map(eventDtoMapper::toResponse)
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Listing successfully completed.");
        response.put("Data List: ", list);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Event event = findEventById.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Data found successfully");
        response.put("Data: ", eventDtoMapper.toResponse(event));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateById(@RequestBody EventRequestDto requestDto, @PathVariable Long id) {
        Event event = eventDtoMapper.toDomain(requestDto);
        updateEventById.execute(event, id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Data updated successfully.");
        response.put("Update Data: ", eventDtoMapper.toResponse(event) );
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<Map<String, Object>> filterIdentifier(@PathVariable String identifier){
        Event event = filterIdentifier.execute(identifier);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event filtered successfully");
        response.put("Event Data: ", eventDtoMapper.toResponse(event));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteById(@PathVariable Long id){
        deleteEventById.execute(id);
        Map<String, String> response = new HashMap<>();
        response.put("Message ", "The id number: " + id + " was successfully deleted");
        return ResponseEntity.ok(response);
    }
}
