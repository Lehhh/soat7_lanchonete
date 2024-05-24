package br.com.fiap.soat7.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}