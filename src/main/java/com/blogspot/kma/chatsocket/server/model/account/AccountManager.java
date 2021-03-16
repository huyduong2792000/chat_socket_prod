package com.blogspot.kma.chatsocket.server.model.account;

import com.blogspot.kma.chatsocket.lib.bean.LoginInfo;
import com.blogspot.kma.chatsocket.lib.bean.Profile;

import java.util.List;

/**
 * Manages accounts.
 */
public interface AccountManager {

    List<Profile> getAllAccounts();

    Profile findAccountByLoginInfo(LoginInfo loginInfo);

    boolean setPasswordHash(String accountId, String currentPasswordHash, String newPasswordHash);

    Profile findAccountByUserName(String username);

    Profile addAccount(String username, String passwordHash, String displayName);

    void updateDetail(Profile profile);
}
