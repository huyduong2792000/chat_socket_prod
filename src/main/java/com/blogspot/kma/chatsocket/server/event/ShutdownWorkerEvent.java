package com.blogspot.kma.chatsocket.server.event;

import com.blogspot.kma.chatsocket.server.model.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shutdown {@link Worker} command.
 * All {@link Worker} that have the corresponding serverSession
 * should shutdown.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShutdownWorkerEvent {
    private int serverSession;
}
