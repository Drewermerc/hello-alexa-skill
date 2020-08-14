package com.alexa.skill;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


/**
 * Handler to be invoked when the skill receives the built in intent AMAZON.StopIntent
 * and AMAZON.CancelIntent
 */
public class CancelAndStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Adios";

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HolaMundo", speechText)
                .withShouldEndSession(true)
                .build();
    }
}
