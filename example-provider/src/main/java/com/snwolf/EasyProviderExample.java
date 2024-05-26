package com.snwolf;

import com.snwolf.registry.LocalRegistry;
import com.snwolf.server.HttpServer;
import com.snwolf.server.impl.VertxHttpServer;
import com.snwolf.service.impl.UserServiceImpl;

public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register("com.snwolf.service.UserService", UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}