package com.blogspot.kma.chatsocket.server.event;

import com.blogspot.kma.chatsocket.lib.bean.ChatMessage;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.server.model.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Chat message that already received from a client will
 * be forwarded to a {@link Worker} to send to the receiver.
 * The {@link Worker} should set the sent result to responseResult.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForwardChatMessageEvent {
    private ChatMessage forwardMessage;
    private String receiverId;
    private Response responseResult;
}
