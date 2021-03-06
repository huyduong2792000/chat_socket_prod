package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.client.event.FriendListReceivedEvent;
import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.bean.ResponseCode;
import com.blogspot.kma.chatsocket.lib.bo.ObjectTransmission;

import java.util.List;

public class FriendListResponseHandler extends AbstractResponseHandler {
    @Override
    @SuppressWarnings("unchecked")
    public void handle(ObjectTransmission transmission, Response response) throws Exception {
        if (response.getCode() == ResponseCode.OK) {
            post(new FriendListReceivedEvent((List<Profile>) response.getExtra()));
        } else {
            showErrorMessage("Can not fetch friend list", response.getExtra());
        }
    }
}
