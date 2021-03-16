package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.client.event.RegisteredEvent;
import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.bean.ResponseCode;
import com.blogspot.kma.chatsocket.lib.bo.ObjectTransmission;

public class RegisterResponseHandler extends AbstractResponseHandler {
    @Override
    public void handle(ObjectTransmission transmission, Response response) throws Exception {
        if (response.getCode() == ResponseCode.OK) {
            post(new RegisteredEvent((Profile) response.getExtra()));
        } else {
            showErrorMessage("Can not register new account", response.getExtra());
        }
    }
}
