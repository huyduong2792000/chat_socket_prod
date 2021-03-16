package com.blogspot.kma.chatsocket.server.view;

import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface MainView extends BaseView {
    String getIp();

    String getPort();

    void setIp(String ip);

    void setPort(int port);

    void setStartButtonText(String text);

    void setStartButtonListener(Runnable listener);
}
