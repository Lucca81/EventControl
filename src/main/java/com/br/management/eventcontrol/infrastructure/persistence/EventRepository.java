package com.br.management.eventcontrol.infrastructure.persistence;

import com.br.management.eventcontrol.core.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<Event> findByIdentifier(String identifier);

}
