package com.blogspot.kma.chatsocket.server.view.swing;

import com.blogspot.kma.chatsocket.lib.view.AbstractViewFactory;
import com.blogspot.kma.chatsocket.server.view.LogView;
import com.blogspot.kma.chatsocket.server.view.MainView;

public class SwingViewFactory extends AbstractViewFactory {
    private MainWindow mainWindow;

    public SwingViewFactory() {
        register(MainView.class, this::createMainWindowIfNecessary);
        register(LogView.class, this::createMainWindowIfNecessary);
    }

    private MainWindow createMainWindowIfNecessary() {
        if (this.mainWindow == null)
            mainWindow = new MainWindow();
        return mainWindow;
    }
}
