package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.NotFoundEventException;

public class DeleteEventByIdUsecaseImpl implements DeleteEventByIdUsecase {
    private final EventGateway eventGateway;

    public DeleteEventByIdUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(Long id) {
        eventGateway.findById(id)
                .orElseThrow(() -> new NotFoundEventException("Event not found with id: " + id));
        eventGateway.deleteEventById(id);
    }
}
