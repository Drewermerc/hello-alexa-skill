package com.alexa.skill;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

/**
 * Handler to be invoked when the skill receives a LaunchRequest.
 * The LaunchRequest event occurs when the skill is invoked without a specific intent.
 */
public class LaunchRequestHandler implements RequestHandler {
    // Method returns true if the incoming request is a LaunchRequest.
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.requestType(LaunchRequest.class));
    }

    // Generates and returns a basic greeting response with response objects such as Speech, Card, and Reprompt
    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Bienvenido a alexa skills kit, puedes decir hello";

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HolaMundo", speechText)
                .withReprompt(speechText)
                .build();
    }
}
