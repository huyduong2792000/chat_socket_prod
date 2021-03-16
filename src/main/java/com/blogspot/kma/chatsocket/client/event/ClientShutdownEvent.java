package com.blogspot.kma.chatsocket.client.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientShutdownEvent {
    private Exception reason;
}
