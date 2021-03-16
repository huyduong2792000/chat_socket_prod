package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface LoginView extends BaseView {
    String getUsername();

    String getPassword();

    void setLoginButtonClickListener(Runnable listener);

    void setRegisterButtonClickListener(Runnable listener);

    void setUserName(String loggedUserName);
}
