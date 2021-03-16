package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.client.event.MyAccountInfoReceivedEvent;
import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.bean.ResponseCode;
import com.blogspot.kma.chatsocket.lib.bo.ObjectTransmission;

public class UpdateProfileResponseHandler extends AbstractResponseHandler {
    @Override
    public void handle(ObjectTransmission transmission, Response response) throws Exception {
        if (response.getCode() == ResponseCode.Fail) {
            showErrorMessage("Can not update user profile", response.getExtra());
        } else {
            post(new MyAccountInfoReceivedEvent((Profile) response.getExtra()));
        }
    }
}
