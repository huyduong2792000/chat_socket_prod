package com.blogspot.kma.chatsocket.server.event;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Occurs when an account info changed.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoChangedEvent {
    private Profile profile;
}
