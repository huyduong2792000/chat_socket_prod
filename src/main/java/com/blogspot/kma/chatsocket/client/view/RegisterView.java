package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface RegisterView extends BaseView {
    void setRegisterButtonClickListener(Runnable listener);

    String getUsername();

    String getPassword();

    String getDisplayName();
}
