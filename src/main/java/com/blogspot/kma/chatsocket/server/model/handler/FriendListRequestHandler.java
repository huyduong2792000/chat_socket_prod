package com.blogspot.kma.chatsocket.server.model.handler;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.server.event.RequestReceivedEvent;
import com.blogspot.kma.chatsocket.server.model.account.AccountManager;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles friend list request from the client.
 */
class FriendListRequestHandler extends AbstractRequestHandler {
    private final AccountManager accountManager;

    FriendListRequestHandler(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    Response handleWithAuthenticated(RequestReceivedEvent event) throws Exception {
        List<Profile> accounts = accountManager.getAllAccounts();

        String exceptId = event.getProfile().getId();
        List<Profile> friends = accounts
                .stream()
                .filter(account -> !account.getId().equals(exceptId))
                .collect(Collectors.toList());

        return okResponse(friends, event.getRequest().getCode());
    }
}
