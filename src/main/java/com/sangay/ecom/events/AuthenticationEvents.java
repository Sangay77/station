package com.sangay.ecom.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationEvents.class);


    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        logger.info("Login successful for user: {}", successEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        logger.error("Login failed for user: {} due to: {}", failureEvent.getAuthentication().getName(),
                failureEvent.getException().getMessage());
    }
}
