package com.blogspot.kma.chatsocket.lib.service;

import com.blogspot.kma.chatsocket.lib.service.event.ShowMessageBoxEvent;
import com.blogspot.kma.chatsocket.lib.service.message.MessageBox;
import com.google.common.eventbus.Subscribe;

public class MessageBoxService extends AbstractService {
    private final MessageBox messageBox;

    public MessageBoxService(MessageBox messageBox) {
        this.messageBox = messageBox;
    }

    @Subscribe
    public void onShowMessageBox(ShowMessageBoxEvent event) {
        runOnUiThread(() -> messageBox.show(event.getCaption(), event.getMessage(), event.getType()));
    }
}
