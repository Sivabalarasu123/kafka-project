package com.springboot.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.kafkaproducer.wikimedia.WikimediaChangesProducer;

@SpringBootApplication
public class KafkaProducerSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerSpringBootApplication.class);
	}

	@Autowired
	private WikimediaChangesProducer wikimediaChangesProducer;
	
	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}

}
