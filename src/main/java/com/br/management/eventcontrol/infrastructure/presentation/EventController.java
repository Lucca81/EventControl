package com.br.management.eventcontrol.infrastructure.presentation;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.usecases.CreateEventUsecase;
import com.br.management.eventcontrol.infrastructure.gateway.EventRepositoryGateway;
import com.br.management.eventcontrol.infrastructure.mapper.EventDtoMapper;
import com.br.management.eventcontrol.infrastructure.reponse.EventResponseDto;
import com.br.management.eventcontrol.infrastructure.request.EventRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUsecase createEvent;
    private final EventDtoMapper eventDtoMapper;
    private  final EventRepositoryGateway eventRepositoryGateway;

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto){
        Event newEvent = createEvent.execute(eventDtoMapper.toDomain(eventRequestDto));
        eventRepositoryGateway.createEvent(newEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventDtoMapper.toResponse(newEvent));
    }
}
