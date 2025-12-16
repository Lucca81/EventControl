package com.br.management.eventcontrol.infrastructure.gateway;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.mapper.EventEntityMapper;
import com.br.management.eventcontrol.infrastructure.persistence.EventEntity;
import com.br.management.eventcontrol.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Event> listEvent() {
         return eventRepository.findAll()
                 .stream()
                 .map(eventEntityMapper::toDomain)
                 .toList();

    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id)
                .map(eventEntityMapper::toDomain);
    }

    @Override
    public Optional<Event> updateById(Event event, Long id) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    existingEvent.setName(event.name());
                    existingEvent.setDescription(event.description());
                    existingEvent.setDateStart(event.dateStart());
                    existingEvent.setDateEnd(event.dateEnd());
                    existingEvent.setIdentifier(event.identifier());
                    existingEvent.setEventLocal(event.eventLocal());
                    existingEvent.setOrganizer(event.organizer());
                    existingEvent.setCapacity(event.capacity());
                    existingEvent.setType(event.type());

                    eventRepository.save(existingEvent);

                    return eventEntityMapper.toDomain(existingEvent);

                });
    }

    @Override
    public Optional<Event> filterIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier);
    }

    @Override
    public boolean identifierExisting(String identifier) {
        return eventRepository.findAll()
                .stream()
                .anyMatch(event-> event.getIdentifier().equalsIgnoreCase(identifier));
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

}
