package com.br.management.eventcontrol.infrastructure.mapper;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.infrastructure.reponse.EventResponseDto;
import com.br.management.eventcontrol.infrastructure.request.EventRequestDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {
    public EventResponseDto toResponse(Event event){
        return new EventResponseDto(
                event.id(),
                event.name(),
                event.description(),
                event.dateStart(),
                event.dateEnd(),
                event.identifier(),
                event.eventLocal(),
                event.organizer(),
                event.capacity(),
                event. type()
        );
    }
    public Event toDomain(EventRequestDto requestDto){
        return new Event(
                requestDto.id(),
                requestDto.name(),
                requestDto.description(),
                requestDto.dateStart(),
                requestDto.dateEnd(),
                requestDto.identifier(),
                requestDto.eventLocal(),
                requestDto.organizer(),
                requestDto.capacity(),
                requestDto.type()
        );
    }
}
