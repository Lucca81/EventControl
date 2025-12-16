package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.gateway.EventGateway;

public class DeleteEventByIdUsecaseImpl implements DeleteEventByIdUsecase {
    private final EventGateway eventGateway;

    public DeleteEventByIdUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(Long id) {
        eventGateway.deleteEventById(id);
    }
}
