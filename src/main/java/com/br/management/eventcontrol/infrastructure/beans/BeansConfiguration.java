package com.br.management.eventcontrol.infrastructure.beans;

import com.br.management.eventcontrol.core.usecases.CreateEventUsecase;
import com.br.management.eventcontrol.core.usecases.CreateEventUsecaseImpl;
import com.br.management.eventcontrol.infrastructure.gateway.EventRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    CreateEventUsecase createEventUsecase(EventRepositoryGateway repositoryGateway){
        return new CreateEventUsecaseImpl(repositoryGateway);
    }

}
