package com.blogspot.kma.chatsocket.server.platform;

import com.blogspot.kma.chatsocket.lib.platform.SwingPlatform;
import com.blogspot.kma.chatsocket.lib.view.ViewFactory;
import com.blogspot.kma.chatsocket.server.view.swing.SwingViewFactory;
import lombok.Getter;

public class ServerSwingPlatform extends SwingPlatform {
    @Getter
    private final ViewFactory viewFactory;

    public ServerSwingPlatform() {
        viewFactory = new SwingViewFactory();
    }
}
