package com.br.management.eventcontrol.core.gateway;

import com.br.management.eventcontrol.core.domain.Event;

public interface EventGateway {
    Event createEvent(Event event);
}
