package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;

public class CreateEventUsecaseImpl implements CreateEventUsecase{

    private final EventGateway eventGateway;

    public CreateEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.createEvent(event);
    }
}
