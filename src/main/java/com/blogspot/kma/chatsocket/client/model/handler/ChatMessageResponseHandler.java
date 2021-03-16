package com.blogspot.kma.chatsocket.client.model.handler;

import com.blogspot.kma.chatsocket.client.model.ChattingManager;
import com.blogspot.kma.chatsocket.lib.bean.ChatMessage;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.bo.ObjectTransmission;

public class ChatMessageResponseHandler extends AbstractResponseHandler {
    private final ChattingManager chattingManager;

    ChatMessageResponseHandler(ChattingManager chattingManager) {
        this.chattingManager = chattingManager;
    }

    @Override
    public void handle(ObjectTransmission transmission, Response response) throws Exception {
        if (response.getExtra() instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) response.getExtra();
            chattingManager.processReceivedChatMessage(chatMessage);
        } else {
            chattingManager.processSentChatMessage(response);
        }
    }
}
