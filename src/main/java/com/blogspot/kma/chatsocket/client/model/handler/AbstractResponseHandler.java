package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.lib.service.AbstractService;
import com.blogspot.kma.chatsocket.lib.service.message.MessageType;

abstract class AbstractResponseHandler extends AbstractService implements ResponseHandler {
    void showErrorMessage(String message, Object reason) {
        postMessageBox(message + ": " + reason, MessageType.Error);
    }
}
