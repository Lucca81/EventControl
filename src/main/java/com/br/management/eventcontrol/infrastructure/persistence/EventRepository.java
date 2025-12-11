package com.br.management.eventcontrol.infrastructure.persistence;

import com.br.management.eventcontrol.core.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
