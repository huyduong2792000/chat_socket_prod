package com.blogspot.kma.chatsocket.client.view.swing.custom;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bo.ImagesResource;
import lombok.Getter;

import javax.swing.*;

public class FriendEntry {
    @Getter
    private final Profile profile;

    public FriendEntry(Profile profile) {
        this.profile = profile;
    }

    public boolean contains(Profile profile) {
        return profile != null && profile.getId() == this.profile.getId();
    }

    public String getDisplayName() {
        return profile.getDisplayName();
    }

    ImageIcon getImage() {
        String imageName = profile.isOnline() ? "online.png" : "offline.png";
        return new ImageIcon(ImagesResource.getInstance().getImageByName(imageName));
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

    String getStatus() {
        return profile.getStatus();
    }
}
