package com.janakerman.utility

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

// TODO: Not working.
@Configuration
class JacksonConfig {

    @Bean
    @Primary
    ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        builder.createXmlMapper(false)
                .build()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    }

}
