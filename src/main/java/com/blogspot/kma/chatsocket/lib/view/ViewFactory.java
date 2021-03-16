package com.blogspot.kma.chatsocket.lib.view;

public interface ViewFactory {
    <T> T create(Class<T> viewType);
}
