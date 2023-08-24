package com.example.libraryeventcon.consumer;

import com.example.libraryeventcon.domain.LibraryEvent;
import com.example.libraryeventcon.repository.LibraryEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EventConsumer {

    @Autowired
    private LibraryEventRepository libraryEventRepository;

    @Autowired
    private ObjectMapper mapper;

    // @KafkaListener internally used ConcurrentMessageListenerContainer
    @KafkaListener(topics = {"library-events"})
    public void onMessage (ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("consumer records:" + consumerRecord);
        final LibraryEvent libraryEvent = mapper.readValue(consumerRecord.value(), LibraryEvent.class);
        save(libraryEvent);
    }

    public void save(LibraryEvent libraryEvent){
        final LibraryEvent save = libraryEventRepository.save(libraryEvent);
        log.info("eventLibrary save operation: "+save);
    }
}
