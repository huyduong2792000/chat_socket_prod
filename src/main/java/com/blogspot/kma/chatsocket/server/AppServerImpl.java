package com.blogspot.kma.chatsocket.server;

import com.blogspot.kma.chatsocket.AppConfig;
import com.blogspot.kma.chatsocket.lib.Component;
import com.blogspot.kma.chatsocket.lib.event.AppShutdownEvent;
import com.blogspot.kma.chatsocket.lib.platform.Platform;
import com.blogspot.kma.chatsocket.lib.service.event.ShowMessageBoxEvent;
import com.blogspot.kma.chatsocket.lib.service.message.MessageType;
import com.blogspot.kma.chatsocket.lib.utils.StreamUtils;
import com.blogspot.kma.chatsocket.server.event.ServerStatusChangedEvent;
import com.blogspot.kma.chatsocket.server.event.StartServerEvent;
import com.blogspot.kma.chatsocket.server.event.StopServerEvent;
import com.blogspot.kma.chatsocket.server.model.RequestRouter;
import com.blogspot.kma.chatsocket.server.model.Server;
import com.blogspot.kma.chatsocket.server.model.SocketServer;
import com.blogspot.kma.chatsocket.server.model.account.AccountManager;
import com.blogspot.kma.chatsocket.server.model.account.AccountManagerImpl;
import com.blogspot.kma.chatsocket.server.model.account.JsonAccountStorage;
import com.blogspot.kma.chatsocket.server.model.handler.RequestHandlerFactory;
import com.blogspot.kma.chatsocket.server.presenter.MainPresenter;
import com.blogspot.kma.chatsocket.server.view.LogView;
import com.blogspot.kma.chatsocket.server.view.MainView;
import com.google.common.eventbus.Subscribe;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

/**
 * Default implementation of {@link AppServer} that uses:
 * <pre>
 * Connection: tcp socket.
 * Store: json file.
 * Serialization: basic java {@link java.io.Serializable} feature.
 * Components communication: guava.
 * </pre>
 */
@Log4j
public class AppServerImpl extends Component implements AppServer {
    private AccountManager accountManager;
    private RequestRouter requestRouter;
    private Server server;

    @Override
    public void start(Platform platform) {
        setPlatform(platform);
        platform.attach(this);
        initializeComponents();
        showUI();
    }

    private void initializeComponents() {
        initializeAccountManager();
        initializeRequestRouter();
    }

    private void initializeAccountManager() {
        try {
            accountManager = new AccountManagerImpl(new JsonAccountStorage("user.json"));
        } catch (IOException e) {
            log.error("Error while initializing account manager", e);
            post(new ShowMessageBoxEvent("Can not initialize account manager", AppConfig.getDefault().getAppName(), MessageType.Error));
        }
    }

    private void initializeRequestRouter() {
        if (accountManager != null) {
            requestRouter = new RequestRouter(new RequestHandlerFactory(accountManager, getPlatform())).build(getPlatform());
        }
    }

    private void showUI() {
        Platform platform = getPlatform();
        MainView mainView = platform.getViewFactory().create(MainView.class);
        LogView logView = platform.getViewFactory().create(LogView.class);
        MainPresenter presenter = new MainPresenter(mainView, logView);
        presenter.setPlatform(platform);
        presenter.show();
    }

    @Subscribe
    public void onStartServer(StartServerEvent event) {
        System.out.println("onStartServer");
        StreamUtils.tryCloseStream(server);
        try {
            startServer(event.getIp(), event.getPort());
            post(new ServerStatusChangedEvent(true));
        } catch (IOException e) {
            log.error("Error while staring server", e);
        }
    }

    private void startServer(String listenOnIp, int port) throws IOException {
        System.out.println("startServer");
        server = new SocketServer(port, listenOnIp, 100).build(getPlatform());
        server.start();

        if (requestRouter != null) {
            requestRouter.start();
        }
    }

    @Subscribe
    public void onStopServer(StopServerEvent event) {
        StreamUtils.tryCloseStream(server);
        if (requestRouter != null) {
            requestRouter.stop();
        }

        post(new ServerStatusChangedEvent(false));
    }

    @Subscribe
    public void onAppShutdown(AppShutdownEvent event) {
        getPlatform().exit();
    }
}
