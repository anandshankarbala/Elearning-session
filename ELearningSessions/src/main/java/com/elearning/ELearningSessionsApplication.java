package com.elearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ELearningSessionsApplication {
	
	private final static Logger log = LoggerFactory.getLogger(ELearningSessionsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ELearningSessionsApplication.class, args);
		log.debug("eLearning Debug Main");
		log.info("eLearning Info Main");
	}

}
