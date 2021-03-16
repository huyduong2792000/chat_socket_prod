package com.blogspot.kma.chatsocket.lib.platform;

import com.blogspot.kma.chatsocket.lib.service.MessageBoxService;
import com.blogspot.kma.chatsocket.lib.service.message.JavaFxMessageBox;
import com.blogspot.kma.chatsocket.lib.thread.JavaFxThreadInvoker;

public abstract class JavaFxPlatform extends AbstractPlatform {
    protected JavaFxPlatform() {
        super(new JavaFxThreadInvoker());
        MessageBoxService messageBoxService = new MessageBoxService(new JavaFxMessageBox());
        messageBoxService.setPlatform(this);
        messageBoxService.start();
    }

    @Override
    public void exit() {
        javafx.application.Platform.exit();
        super.exit();
    }
}
