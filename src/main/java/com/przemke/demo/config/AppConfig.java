package com.przemke.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.przemke.demo")
public class AppConfig {
}
