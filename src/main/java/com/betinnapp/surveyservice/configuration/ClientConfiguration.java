package com.betinnapp.surveyservice.configuration;

import com.betinnapp.surveyservice.clients.UserClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public OkHttpClient OkHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public UserClient userServiceClient(@Value("${services.user.url}") String userServiceUrl) {
        CircuitBreaker circuitBreaker = CircuitBreaker
                .ofDefaults("userService");

        FeignDecorators decorators = FeignDecorators
                .builder()
                .withCircuitBreaker(circuitBreaker)
                .build();

        return Resilience4jFeign
                .builder(decorators)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserClient.class, userServiceUrl);
    }
}
