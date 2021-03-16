package com.blogspot.kma.chatsocket.lib.view;

public interface BaseView {
    void showWindow();

    void closeWindow();

    void setTitle(String title);

    void setOnClosingListener(Runnable listener);

    void setMainWindow();

    boolean isMainWindow();
}
