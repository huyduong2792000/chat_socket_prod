package com.blogspot.kma.chatsocket.lib;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException() {
    }

    public NotRegisteredException(String msg) {
        super(msg);
    }
}
