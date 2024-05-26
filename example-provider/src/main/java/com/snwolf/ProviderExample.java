package com.snwolf;

import com.snwolf.registry.LocalRegistry;
import com.snwolf.server.HttpServer;
import com.snwolf.server.impl.VertxHttpServer;
import com.snwolf.service.UserService;
import com.snwolf.service.impl.UserServiceImpl;

public class ProviderExample {

    public static void main(String[] args) {
        RpcApplication.init();

        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
