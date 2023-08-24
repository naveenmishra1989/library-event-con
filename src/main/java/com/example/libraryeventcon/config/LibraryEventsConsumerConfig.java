package com.example.libraryeventcon.config;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
@EnableKafka
public class LibraryEventsConsumerConfig {

    @Bean
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory (ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
                                                                                 ConsumerFactory<Object, Object> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(listenerContainerFactory, consumerFactory);
        listenerContainerFactory.setConcurrency(3);
        return listenerContainerFactory;
    }
}
