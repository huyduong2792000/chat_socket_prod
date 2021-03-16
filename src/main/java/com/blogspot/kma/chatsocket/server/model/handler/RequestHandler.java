package com.blogspot.kma.chatsocket.server.model.handler;

import com.blogspot.kma.chatsocket.server.event.RequestReceivedEvent;

public interface RequestHandler {
    void handle(RequestReceivedEvent event) throws Exception;
}
