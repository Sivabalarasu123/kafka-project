package com.springboot.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.kafkaconsumer.entity.WikimediaData;
import com.springboot.kafkaconsumer.repository.WikimediaDataRepository;

@Service
public class KafkaConsumer {
	
	private WikimediaDataRepository dataRepository;

	public KafkaConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}" ,groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event message recieved -> %s", eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		dataRepository.save(wikimediaData);
		
	}
}
