package com.br.management.eventcontrol.infrastructure.persistence;

import com.br.management.eventcontrol.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")

public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "date_start")
    private LocalDateTime dateStart;
    @Column(name = "date_end")
    private LocalDateTime dateEnd;
    @Column(unique = true)
    private String identifier;
    @Column(name = "event_local")
    private String eventLocal;
    private String organizer;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private EventType type;
}
