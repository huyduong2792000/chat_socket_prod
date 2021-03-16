package com.blogspot.kma.chatsocket.client.platform;

import com.blogspot.kma.chatsocket.client.view.swing.SwingViewFactory;
import com.blogspot.kma.chatsocket.lib.platform.SwingPlatform;
import com.blogspot.kma.chatsocket.lib.view.ViewFactory;
import lombok.Getter;

public class ClientSwingPlatform extends SwingPlatform {
    @Getter
    private final ViewFactory viewFactory;

    public ClientSwingPlatform() {
        viewFactory = new SwingViewFactory();
    }
}
