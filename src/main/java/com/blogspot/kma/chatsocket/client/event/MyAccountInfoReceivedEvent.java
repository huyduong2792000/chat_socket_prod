package com.blogspot.kma.chatsocket.client.event;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyAccountInfoReceivedEvent {
    private Profile myProfile;
}
