package com.blogspot.kma.chatsocket.client.event;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendListReceivedEvent {
    private List<Profile> friendList;
}
