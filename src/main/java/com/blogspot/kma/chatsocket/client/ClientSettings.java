package com.blogspot.kma.chatsocket.client;

import com.blogspot.kma.chatsocket.lib.settings.Setting;
import lombok.Data;

@Data
@Setting(key = "client")
public class ClientSettings {
    private String serverIp;
    private int serverPort;
    private String loggedUserName;
}
