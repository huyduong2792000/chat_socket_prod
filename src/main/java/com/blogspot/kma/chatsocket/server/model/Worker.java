package com.blogspot.kma.chatsocket.server.model;

import com.blogspot.kma.chatsocket.lib.bean.Profile;

import java.io.IOException;

/**
 * Communicates with an individual client.
 */
public interface Worker {
    void start();

    void response(Object obj) throws IOException;

    void setAccount(Profile account);
}
