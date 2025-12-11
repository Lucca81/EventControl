package com.br.management.eventcontrol.infrastructure.gateway;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.mapper.EventEntityMapper;
import com.br.management.eventcontrol.infrastructure.persistence.EventEntity;
import com.br.management.eventcontrol.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity newEvent= eventRepository.save(entity);
        return eventEntityMapper.toDomain(newEvent);
    }
}
