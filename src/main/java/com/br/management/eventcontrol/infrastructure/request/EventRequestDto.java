package com.br.management.eventcontrol.infrastructure.request;

import com.br.management.eventcontrol.core.enums.EventType;

import java.time.LocalDateTime;

public record EventRequestDto(Long id,
                              String name,
                              String description,
                              LocalDateTime dateStart,
                              LocalDateTime dateEnd,
                              String identifier,
                              String eventLocal,
                              String organizer,
                              Integer capacity,
                              EventType type) {
}
