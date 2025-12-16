package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;

import java.util.Optional;

public interface FindEventByIdUsecase {
    Event execute(Long id);
}
