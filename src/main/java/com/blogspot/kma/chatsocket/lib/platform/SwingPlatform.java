package com.blogspot.kma.chatsocket.lib.platform;

import com.blogspot.kma.chatsocket.lib.service.MessageBoxService;
import com.blogspot.kma.chatsocket.lib.service.message.SwingMessageBox;
import com.blogspot.kma.chatsocket.lib.thread.SwingThreadInvoker;
import com.blogspot.kma.chatsocket.lib.view.WindowUtils;

public abstract class SwingPlatform extends AbstractPlatform {
    protected SwingPlatform() {
        super(new SwingThreadInvoker());
        WindowUtils.setSystemLookAndFeel();
        MessageBoxService messageBoxService = new MessageBoxService(new SwingMessageBox());
        messageBoxService.setPlatform(this);
        messageBoxService.start();
    }
}
