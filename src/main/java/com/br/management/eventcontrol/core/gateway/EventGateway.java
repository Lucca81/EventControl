package com.br.management.eventcontrol.core.gateway;

import com.br.management.eventcontrol.core.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {
    Event createEvent(Event event);
    List<Event> listEvent();
    Optional<Event> findById(Long id);
    Optional<Event> updateById(Event event, Long id);
    Optional<Event> filterIdentifier(String identifier);
    boolean identifierExisting(String identifier);
    void deleteEventById(Long id);

}
