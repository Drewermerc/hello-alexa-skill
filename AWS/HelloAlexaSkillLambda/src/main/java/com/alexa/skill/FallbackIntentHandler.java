package com.alexa.skill;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


/**
 * Handler to be invoked when the skill receives the built in intent AMAZON.FallbackIntent
 */
public class FallbackIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Perdon, no se que quisiste decir, Tu puede intentar diciendo ayuda!";

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HolaMundo", speechText)
                .withReprompt(speechText)
                .build();
    }
}
