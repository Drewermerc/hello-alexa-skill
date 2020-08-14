package com.alexa.skill;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

/**
 * Handler gives us a good place for us to put our cleanup logic.
 */
public class SessionEndedRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(requestType(SessionEndedRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        // any cleanup logic goes here
        return handlerInput.getResponseBuilder().build();
    }
}
