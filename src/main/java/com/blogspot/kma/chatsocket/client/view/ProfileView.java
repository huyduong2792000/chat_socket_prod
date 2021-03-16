package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.client.model.UserProfile;
import com.blogspot.kma.chatsocket.lib.Callback;
import com.blogspot.kma.chatsocket.lib.bean.UpdatePassword;
import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface ProfileView extends BaseView {
    void setChangeDisplayNameButtonClickListener(Callback<String> listener);

    void setChangeStatusButtonClickListener(Callback<String> listener);

    void setChangePasswordButtonClickListener(Callback<UpdatePassword> listener);

    void setProfile(UserProfile userProfile);
}
