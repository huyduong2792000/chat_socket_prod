package com.blogspot.kma.chatsocket.client.view.javafx.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageInternal {
    private String content;
    private boolean isMe;
}
