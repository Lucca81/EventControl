package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;

public interface FilterIdentifierEventUsecase {
    Event execute(String identifier);
}
