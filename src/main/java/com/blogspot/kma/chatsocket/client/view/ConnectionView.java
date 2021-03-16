package com.blogspot.kma.chatsocket.client.view;

import com.blogspot.kma.chatsocket.lib.view.BaseView;

public interface ConnectionView extends BaseView {
    void setConnectButtonClickListener(Runnable listener);

    String getServerIp();

    String getServerPort();

    void setServerIp(String serverIp);

    void setServerPort(int serverPort);
}
