package com.blogspot.kma.chatsocket.server.model.handler;

import com.blogspot.kma.chatsocket.lib.bean.Profile;
import com.blogspot.kma.chatsocket.lib.bean.Request;
import com.blogspot.kma.chatsocket.lib.bean.Response;
import com.blogspot.kma.chatsocket.lib.utils.Security;
import com.blogspot.kma.chatsocket.server.event.RequestReceivedEvent;
import com.blogspot.kma.chatsocket.server.model.account.AccountManager;

/**
 * Handles updating user's profile request from the client.
 */
class UpdateProfileRequestHandler extends AbstractRequestHandler {
    private final AccountManager accountManager;

    UpdateProfileRequestHandler(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    Response handleWithAuthenticated(RequestReceivedEvent event) throws Exception {
        Request request = event.getRequest();
        if (request.getExtra() != null && request.getExtra() instanceof Profile) {
            Profile updateFrom = (Profile) request.getExtra();
            if (Security.checkValidDisplayName(updateFrom.getDisplayName())) {
                Profile updateTo = event.getProfile();
                updateTo.setDisplayName(updateFrom.getDisplayName());
                updateTo.setStatus(updateFrom.getStatus());

                accountManager.updateDetail(updateTo);
                broadcastAccountInfoChanged(updateTo);
                return okResponse(updateTo, event.getRequest().getCode());
            }
        }
        return failResponse("Invalid display name", event.getRequest().getCode());
    }
}
