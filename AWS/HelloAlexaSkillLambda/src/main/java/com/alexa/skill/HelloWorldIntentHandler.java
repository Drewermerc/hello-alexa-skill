package com.alexa.skill;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;


/**
 * Handler to be invoked when the skill receives the HelloWorldIntent
 */
public class HelloWorldIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("HolaMundoIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Hola Mundo";

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HolaMundo", speechText)
                .build();
    }
}
