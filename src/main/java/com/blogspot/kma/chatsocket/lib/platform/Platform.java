package com.blogspot.kma.chatsocket.lib.platform;

import com.blogspot.kma.chatsocket.lib.settings.SettingsLoader;
import com.blogspot.kma.chatsocket.lib.thread.ThreadInvoker;
import com.blogspot.kma.chatsocket.lib.view.ViewFactory;

public interface Platform {
    ViewFactory getViewFactory();

    ThreadInvoker getThreadInvoker();

    SettingsLoader getSettings();

    void attach(Object service);

    void detach(Object service);

    void postEvent(Object event);

    void exit();
}
