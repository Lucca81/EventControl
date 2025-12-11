package com.br.management.eventcontrol.core.domain;

import com.br.management.eventcontrol.core.enums.EventType;

import java.time.LocalDateTime;

public record Event(Long id,
                    String name,
                    String description,
                    LocalDateTime dateStart,
                    LocalDateTime dateEnd,
                    String identifier,
                    String eventLocal,
                    String organizer,
                    Integer capacity,
                    EventType type

) {
}
