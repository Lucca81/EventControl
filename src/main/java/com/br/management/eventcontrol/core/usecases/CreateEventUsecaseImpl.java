package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.DuplicateEventException;

import java.util.UUID;

public class CreateEventUsecaseImpl implements CreateEventUsecase{

    private final EventGateway eventGateway;

    public CreateEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        String uuid = UUID.randomUUID().toString();

        Event eventWithIdentifier = new Event(
                event.id(),
                event.name(),
                event.description(),
                event.dateStart(),
                event.dateEnd(),
                uuid,
                event.eventLocal(),
                event.organizer(),
                event.capacity(),
                event.type()
        );
        return eventGateway.createEvent(eventWithIdentifier);
    }
}
