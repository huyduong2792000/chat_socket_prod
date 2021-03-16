package com.blogspot.kma.chatsocket.lib;

import com.blogspot.kma.chatsocket.lib.platform.Platform;

public interface Presenter {
    void show();

    void setPlatform(Platform platform);
}
