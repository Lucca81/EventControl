package com.br.management.eventcontrol.infrastructure.mapper;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {
    public Event toDomain(EventEntity entity){
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDateStart(),
                entity.getDateEnd(),
                entity.getIdentifier(),
                entity.getEventLocal(),
                entity.getOrganizer(),
                entity.getCapacity(),
                entity.getType()

        );
    }
    public EventEntity toEntity(Event event) {
        return new EventEntity(
                event.id(),
                event.name(),
                event.description(),
                event.dateStart(),
                event.dateEnd(),
                event.identifier(),
                event.eventLocal(),
                event.organizer(),
                event.capacity(),
                event.type()
        );
    }
}
