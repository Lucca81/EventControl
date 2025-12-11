package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;

public interface CreateEventUsecase {

    Event execute(Event event);
}
