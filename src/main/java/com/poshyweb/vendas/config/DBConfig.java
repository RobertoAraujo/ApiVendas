package com.poshyweb.vendas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dsv")
public class DBConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public CommandLineRunner executar(){
        return args -> {
        LOGGER.info("Rodando a configuração de desenvolvimento");
        };
    }
}
