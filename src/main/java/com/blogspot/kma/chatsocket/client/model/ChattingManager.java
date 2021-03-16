package com.blogspot.kma.chatsocket.client.model;

import com.blogspot.kma.chatsocket.lib.bean.ChatMessage;
import com.blogspot.kma.chatsocket.lib.bean.Response;

/**
 * Manages received chat messages.
 */
public interface ChattingManager {
    void start();

    void stop();

    void processReceivedChatMessage(ChatMessage chatMessage);

    void processSentChatMessage(Response response);
}
