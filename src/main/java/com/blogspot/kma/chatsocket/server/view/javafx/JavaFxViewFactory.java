package com.blogspot.kma.chatsocket.server.view.javafx;

import com.blogspot.kma.chatsocket.lib.view.AbstractViewFactory;
import com.blogspot.kma.chatsocket.server.view.LogView;
import com.blogspot.kma.chatsocket.server.view.MainView;
import com.sun.javafx.application.PlatformImpl;

public class JavaFxViewFactory extends AbstractViewFactory {
    private MainWindow mainWindow;

    public JavaFxViewFactory() {
        register(MainView.class, this::createMainWindowIfNecessary);
        register(LogView.class, this::createMainWindowIfNecessary);
    }

    private MainWindow createMainWindowIfNecessary() {
        if (mainWindow == null) {
            PlatformImpl.runAndWait(() -> mainWindow = new MainWindow());
        }
        return mainWindow;
    }
}
