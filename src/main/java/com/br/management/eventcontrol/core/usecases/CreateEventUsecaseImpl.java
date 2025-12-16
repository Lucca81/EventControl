package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.DuplicateEventException;

public class CreateEventUsecaseImpl implements CreateEventUsecase{

    private final EventGateway eventGateway;

    public CreateEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if (eventGateway.identifierExisting(event.identifier()))
            throw new DuplicateEventException("The identifier number: " + event.identifier() + "Is already in use for another event");
        return eventGateway.createEvent(event);
    }
}
