package com.br.management.eventcontrol.infrastructure.beans;

import com.br.management.eventcontrol.core.usecases.*;
import com.br.management.eventcontrol.infrastructure.gateway.EventRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    CreateEventUsecase createEventUsecase(EventRepositoryGateway repositoryGateway) {
        return new CreateEventUsecaseImpl(repositoryGateway);
    }

    @Bean
    ListEventUsecase listEventUsecase(EventRepositoryGateway repositoryGateway) {
        return new ListEventUsecaseImpl(repositoryGateway);
    }

    @Bean
    FindEventByIdUsecase findEventByIdUsecase(EventRepositoryGateway repositoryGateway) {
        return new FindEventByIdUsecaseImpl(repositoryGateway);
    }

    @Bean
    UpdateEventByIdUsecase updateEventByIdUsecase(EventRepositoryGateway repositoryGateway) {
        return new UpdateEventByIdUsecaseImpl(repositoryGateway);
    }
    @Bean
    FilterIdentifierEventUsecase filterIdentifierEventUsecase(EventRepositoryGateway repositoryGateway){
        return new FilterIdentifierEventUsecaseImpl(repositoryGateway);
    }

    @Bean
    DeleteEventByIdUsecase deleteEventByIdUsecase(EventRepositoryGateway repositoryGateway){
        return  new DeleteEventByIdUsecaseImpl(repositoryGateway);
    }

}
