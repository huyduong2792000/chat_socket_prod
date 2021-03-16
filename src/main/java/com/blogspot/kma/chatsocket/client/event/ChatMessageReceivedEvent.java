package com.blogspot.kma.chatsocket.client.event;

import com.blogspot.kma.chatsocket.lib.bean.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageReceivedEvent {
    private ChatMessage chatMessage;
}
