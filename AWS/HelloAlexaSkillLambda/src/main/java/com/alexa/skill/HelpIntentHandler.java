package com.alexa.skill;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


/**
 * Handler to be invoked when the skill receives the built in intent AMAZON.HelpIntent
 */
public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Me puedes decir hola a mi";

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HolaMundo", speechText)
                .withReprompt(speechText)
                .build();
    }
}
