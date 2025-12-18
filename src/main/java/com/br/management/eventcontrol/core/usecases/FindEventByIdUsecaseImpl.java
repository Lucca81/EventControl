package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.NotFoundEventException;

public class FindEventByIdUsecaseImpl  implements  FindEventByIdUsecase{

    private  final EventGateway eventGateway;

    public FindEventByIdUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id) {
        return eventGateway.findById(id)
                .orElseThrow(()-> new NotFoundEventException("Event with id: " + id + " does not exist"));
    }
}
