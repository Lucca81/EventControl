package com.br.management.eventcontrol.core.usecases;

import com.br.management.eventcontrol.core.domain.Event;

import java.util.List;

public interface ListEventUsecase {
    List<Event> execute();
}
