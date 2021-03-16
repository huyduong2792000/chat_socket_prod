package com.blogspot.kma.chatsocket.client.view.javafx;

import com.blogspot.kma.chatsocket.client.view.*;
import com.blogspot.kma.chatsocket.lib.view.AbstractViewFactory;

public class JavaFxViewFactory extends AbstractViewFactory {

    public JavaFxViewFactory() {
        register(ChatView.class, ChatWindow::new);
        register(ConnectionView.class, ConnectionWindow::new);
        register(FriendListView.class, FriendListWindow::new);
        register(LoginView.class, LoginWindow::new);
        register(ProfileView.class, ProfileWindow::new);
        register(RegisterView.class, RegisterWindow::new);
    }
}
