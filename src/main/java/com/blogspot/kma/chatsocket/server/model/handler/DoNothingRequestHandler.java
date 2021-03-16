package com.blogspot.kma.chatsocket.server.model.handler;

import com.blogspot.kma.chatsocket.server.event.RequestReceivedEvent;

public class DoNothingRequestHandler extends AbstractRequestHandler {
    @Override
    public void handle(RequestReceivedEvent event) throws Exception {
    }
}
