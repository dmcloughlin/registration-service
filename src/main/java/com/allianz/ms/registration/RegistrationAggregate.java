package com.allianz.ms.registration;

import com.allianz.ms.registration.commands.RegisterDetailsCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dmcloughlin on 17/01/2018.
 */
@Aggregate
public class RegistrationAggregate {

    private final static Logger LOG = LoggerFactory.getLogger(RegistrationAggregate.class);

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public RegistrationAggregate(RegisterDetailsCommand command) {

        LOG.debug("Command received: " + command);
        apply(new RegistrationDetailsValidated(command.getId(), command.getEmail(), command.getMemberNumber(),
                command.getDob()));
    }

    @EventSourcingHandler
    public void on(RegistrationDetailsValidated event) {

        this.id = event.getId();
    }
}