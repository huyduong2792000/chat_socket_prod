package com.blogspot.kma.chatsocket.server;

import com.blogspot.kma.chatsocket.lib.settings.Setting;
import lombok.Data;

@Data
@Setting(key = "server")
public class ServerSettings {
    private String ip;
    private int port;
}
