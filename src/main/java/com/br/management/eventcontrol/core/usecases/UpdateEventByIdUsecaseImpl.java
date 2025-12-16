package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.NotFoundEventExeption;

public class UpdateEventByIdUsecaseImpl implements UpdateEventByIdUsecase {
    private final EventGateway eventGateway;

    public UpdateEventByIdUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event, Long id) {
        return eventGateway.updateById(event, id).orElseThrow(()-> new NotFoundEventExeption("Event with id: " + id + " does not exist"));
    }
}
