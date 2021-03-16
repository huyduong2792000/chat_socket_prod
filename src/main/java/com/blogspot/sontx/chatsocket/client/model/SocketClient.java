package com.blogspot.sontx.chatsocket.client.model;

import com.blogspot.sontx.chatsocket.client.event.*;
import com.blogspot.sontx.chatsocket.client.model.handler.ResponseHandler;
import com.blogspot.sontx.chatsocket.client.model.handler.ResponseHandlerFactory;
import com.blogspot.sontx.chatsocket.lib.bean.*;
import com.blogspot.sontx.chatsocket.lib.bo.DefaultObjectTransmission;
import com.blogspot.sontx.chatsocket.lib.bo.ObjectTransmission;
import com.blogspot.sontx.chatsocket.lib.bo.SerializableObjectAdapter;
import com.blogspot.sontx.chatsocket.lib.bo.SocketByteTransmission;
import com.blogspot.sontx.chatsocket.lib.service.BackgroundService;
import com.blogspot.sontx.chatsocket.lib.utils.StreamUtils;
import com.google.common.eventbus.Subscribe;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.Socket;

@Log4j
public class SocketClient extends BackgroundService implements Client {
    private final String serverIp;
    private final int serverPort;
    private final ResponseHandlerFactory responseHandlerFactory;
    private ObjectTransmission transmission;
    private volatile boolean closing;

    public SocketClient(
            String serverIp,
            int serverPort,
            ResponseHandlerFactory responseHandlerFactory) {

        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.responseHandlerFactory = responseHandlerFactory;
    }

    @Override
    public void run() {
        closing = false;
        try {
            connect();
            waitForIncommingMessages();
            shutdownClientWithoutError();
        } catch (Exception e) {
            if (closing)
                shutdownClientWithoutError();
            else
                shutdownClientWithError(e);
        }
    }

    private void shutdownClientWithError(Exception e) {
        log.error("Error while running socket client", e);
        post(new ClientShutdownEvent(e));
    }

    private void shutdownClientWithoutError() {
        post(new ClientShutdownEvent());
        StreamUtils.tryCloseStream(this);
    }

    private void connect() throws IOException {
        StreamUtils.tryCloseStream(transmission);
        Socket socket = new Socket(serverIp, serverPort);
        transmission = new DefaultObjectTransmission(new SerializableObjectAdapter(), new SocketByteTransmission(socket));
        post(new ConnectedToServerEvent());
    }

    private void waitForIncommingMessages() throws Exception {
        while (!closing) {
            Object receivedMessage = transmission.receiveObject();
            System.out.println("------receivedMessage-----" + receivedMessage);
            if (receivedMessage instanceof Response) {
                handleResponse((Response) receivedMessage);
            }
        }
    }

    private void handleResponse(Response response) throws Exception {
        ResponseHandler handler = responseHandlerFactory.create(response.getRequestCode());
        handler.handle(transmission, response);
    }

    @Subscribe
    public void onLogin(LoginEvent event) {
        runAsync(() -> sendRequest(new LoginInfo(event.getUsername(), event.getPassword()), RequestCode.Login));
    }

    @Subscribe
    public void onRegister(RegisterEvent event) {
        runAsync(() -> sendRequest(new RegisterInfo(event.getUsername(), event.getPassword(), event.getDisplayName()), RequestCode.Register));
    }

    @Subscribe
    public void onUpdateFriendList(UpdateFriendListEvent event) {
        runAsync(() -> sendRequest(null, RequestCode.FriendList));
    }

    @Subscribe
    public void onUpdateProfile(UpdateProfileEvent event) {
        runAsync(() -> sendRequest(event.getProfile(), RequestCode.UpdateProfile));
    }

    @Subscribe
    public void onUpdatePassword(UpdatePasswordEvent event) {
        runAsync(() -> sendRequest(event.getUpdatePassword(), RequestCode.UpdatePassword));
    }

    @Subscribe
    public void onSendChatMessage(SendChatMessageEvent event) {
        runAsync(() -> sendRequest(event.getChatMessage(), RequestCode.ChatMessage));
    }

    private void sendRequest(Object extra, RequestCode requestCode) {
        if (transmission == null) return;

        Request request = new Request();
        request.setExtra(extra);
        request.setCode(requestCode);
        try {
            transmission.sendObject(request);
        } catch (IOException e) {
            shutdownClientWithError(e);
        }
    }

    @Override
    public void close() {
        closing = true;
        StreamUtils.tryCloseStream(transmission);
        stop();
    }
}
