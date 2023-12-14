package com.pracone;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class PractiseOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiseOneApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        System.out.println("In Model Mapper Bean");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}
