package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;

public interface UpdateEventByIdUsecase {
    Event execute(Event event, Long id);
}
