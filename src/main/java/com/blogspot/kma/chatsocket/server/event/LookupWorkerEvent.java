package com.blogspot.kma.chatsocket.server.event;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.server.model.Worker;
import lombok.Data;

/**
 * Finds a running {@link Worker} by an {@link Profile}.
 */
@Data
public class LookupWorkerEvent {
    private Profile matchedAccount;
    private Worker matchedWorker;
}
