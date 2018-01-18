package com.allianz.ms.registration.controller;

import com.allianz.ms.registration.commands.RegisterDetailsCommand;
import com.allianz.ms.registration.domain.RegisterDetails;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by dmcloughlin on 17/01/2018.
 */
@RestController
public class RegistrationController {

    private CommandGateway commandGateway;

    public RegistrationController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @PostMapping
    public void registerDetails(@RequestBody RegisterDetails registerDetails) {

        String uuid = UUID.randomUUID().toString();

        this.commandGateway.send(new RegisterDetailsCommand(uuid,
                registerDetails.getEmail(), registerDetails.getMemberNumber(), registerDetails.getDob())
        );
    }
}
