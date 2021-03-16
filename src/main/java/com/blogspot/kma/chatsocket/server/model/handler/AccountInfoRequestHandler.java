package com.blogspot.kma.chatsocket.server.model.handler;

import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.server.event.RequestReceivedEvent;

/**
 * Handles account info request from the client.
 */
class AccountInfoRequestHandler extends AbstractRequestHandler {
    @Override
    Response handleWithAuthenticated(RequestReceivedEvent event) throws Exception {
        return okResponse(event.getProfile(), event.getRequest().getCode());
    }
}
