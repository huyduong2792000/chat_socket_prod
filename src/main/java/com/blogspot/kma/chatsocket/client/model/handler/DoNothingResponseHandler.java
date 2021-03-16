package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.bo.ObjectTransmission;

public class DoNothingResponseHandler extends AbstractResponseHandler {
    @Override
    public void handle(ObjectTransmission transmission, Response response) throws Exception {
    }
}
