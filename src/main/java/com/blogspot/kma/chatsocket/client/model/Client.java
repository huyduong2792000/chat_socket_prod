package com.blogspot.kma.chatsocket.client.model;

import com.blogspot.kma.chatsocket.server.model.Server;

import java.io.Closeable;

/**
 * Lowest layer that communicates with {@link Server}.
 */
public interface Client extends Closeable {
    void start();
}
