package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.lib.Callback;
import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface ChatView extends BaseView {
    void appendFriendMessage(String message);

    void appendMeMyMessage(String message);

    void setSendButtonClickListener(Callback<String> listener);

    void clearInput();
}
