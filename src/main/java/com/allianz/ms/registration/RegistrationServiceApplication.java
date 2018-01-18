package com.allianz.ms.registration;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RegistrationServiceApplication {

    private final static Logger LOG = LoggerFactory.getLogger(RegistrationServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}

	@Component
	public static class RegistrationDbUpdater {

	    @EventHandler
        public void on(RegistrationDetailsValidated event) {


	        LOG.debug("Received event " + event.toString() + " into handler.");
        }
    }
}