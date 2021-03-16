package com.blogspot.kma.chatsocket.client.event;

import com.blogspot.kma.chatsocket.lib.bean.UpdatePassword;
import lombok.Data;

@Data
public class UpdatePasswordEvent {
    private UpdatePassword updatePassword;
}
