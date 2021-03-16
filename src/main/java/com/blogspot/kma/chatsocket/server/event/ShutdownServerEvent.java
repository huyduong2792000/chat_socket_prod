package com.blogspot.kma.chatsocket.server.event;

import com.blogspot.kma.chatsocket.server.model.Server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shutdown {@link Server} command.
 * All {@link Server} that have corresponding sessionId
 * should shutdown.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShutdownServerEvent {
    public static final int ALL = -1;

    private int sessionId;
}
