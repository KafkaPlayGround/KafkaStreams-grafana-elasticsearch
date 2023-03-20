package me.saechimdaeki.checkoutproducer.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun customObjectMapper(): ObjectMapper {
        return ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(JavaTimeModule())
    }

    @Bean
    fun modelMapper() = ModelMapper().apply {
        configuration.isFieldMatchingEnabled = true
        configuration.fieldAccessLevel = org.modelmapper.config.Configuration.AccessLevel.PRIVATE
    }
}