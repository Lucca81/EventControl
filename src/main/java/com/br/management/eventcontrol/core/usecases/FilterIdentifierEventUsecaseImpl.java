package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;
import com.br.management.eventcontrol.infrastructure.exception.EventExceptionIdentifierNotFound;

public class FilterIdentifierEventUsecaseImpl implements FilterIdentifierEventUsecase{
    private final EventGateway eventGateway;

    public FilterIdentifierEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.filterIdentifier(identifier)
                .orElseThrow(()-> new EventExceptionIdentifierNotFound("Event with identifier: " + identifier + " does not exist"));
    }
}
