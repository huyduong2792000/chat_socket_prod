package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.lib.Callback;
import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.view.BaseView;

import java.util.List;

public interface FriendListView extends BaseView {
    void setMyInfoButtonClickListener(Runnable listener);

    void setFriendButtonClickListener(Callback<Profile> listener);

    void setFriendList(List<Profile> friendProfileList);

    void setMyAccountInfo(Profile profile);

    void updateFriend(Profile friendInfo);

    void addNewFriend(Profile newFriendInfo);
}
