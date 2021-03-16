package com.blogspot.kma.chatsocket.server.model.account;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import lombok.Data;

@Data
class Account {
    private String id;
    private String username;
    private String passwordHash;
    private Profile profile;
}
