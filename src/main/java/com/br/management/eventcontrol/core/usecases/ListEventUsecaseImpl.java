package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;
import com.br.management.eventcontrol.core.gateway.EventGateway;

import java.util.List;

public class ListEventUsecaseImpl implements ListEventUsecase{
    private final EventGateway eventGateway;

    public ListEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.listEvent();
    }
}
