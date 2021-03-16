package com.blogspot.kma.chatsocket.lib.service;

import com.blogspot.kma.chatsocket.lib.platform.Platform;

public interface Service {
    int getId();

    void setPlatform(Platform platform);

    void start();

    void stop();
}
