package com.blogspot.kma.chatsocket.client.view.javafx;

import com.blogspot.kma.chatsocket.client.view.FriendListView;
import com.blogspot.kma.chatsocket.client.view.javafx.custom.FriendListViewCell;
import com.blogspot.kma.chatsocket.lib.Callback;
import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.view.AbstractJavaFxWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

class FriendListWindow extends AbstractJavaFxWindow implements FriendListView {
    private final ObservableList<Profile> friends = FXCollections.observableArrayList();
    @FXML
    private Label statusLabel;
    @FXML
    private ImageView avatarImageView;
    @FXML
    private ListView<Profile> friendListView;
    @Setter
    private Runnable myInfoButtonClickListener;
    @Setter
    private Callback<Profile> friendButtonClickListener;

    FriendListWindow() {
        init(this, "friend-list-window.fxml");
        friendListView.setCellFactory(listView -> new FriendListViewCell());
        friendListView.setItems(friends);
    }

    @FXML
    private void onListViewItemClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Profile selectedItem = friendListView.getSelectionModel().getSelectedItem();
            if (friendButtonClickListener != null && selectedItem != null)
                friendButtonClickListener.call(selectedItem);
        }
    }

    @FXML
    private void onMyInfoClick(MouseEvent event) {
        if (event.getClickCount() == 2 && myInfoButtonClickListener != null)
            myInfoButtonClickListener.run();
    }

    @Override
    public void setFriendList(List<Profile> friendProfileList) {
        friends.addAll(friendProfileList);
    }

    @Override
    public void setMyAccountInfo(Profile profile) {
        if (profile != null && !StringUtils.isEmpty(profile.getStatus())) {
            statusLabel.setText(profile.getStatus());
        } else {
            statusLabel.setText("Hi there!");
        }
    }

    @Override
    public void updateFriend(Profile friendInfo) {
        Optional<Profile> matchedFriend = friends
                .stream()
                .filter(accountInfo -> accountInfo.getId().equals(friendInfo.getId()))
                .findFirst();

        matchedFriend.ifPresent(accountInfo -> friends.set(friends.indexOf(accountInfo), friendInfo));
    }

    @Override
    public void addNewFriend(Profile newFriendInfo) {
        friends.add(newFriendInfo);
    }
}
