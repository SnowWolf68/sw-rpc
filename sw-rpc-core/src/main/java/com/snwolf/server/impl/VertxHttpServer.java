package com.snwolf.server.impl;

import com.snwolf.handler.HttpServerHandler;
import com.snwolf.server.HttpServer;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VertxHttpServer implements HttpServer {
    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();

        io.vertx.core.http.HttpServer httpServer = vertx.createHttpServer();

       /* httpServer.requestHandler(httpServerRequest -> {
            log.info("Received Request: requestMethod: {}, requestUri: {}",
                    httpServerRequest.method(),
                    httpServerRequest.uri());

            httpServerRequest.response()
                    .putHeader("content-type", "text/plain")
                    .end("Response from Vert.x!");
        });*/

        httpServer.requestHandler(new HttpServerHandler());

        httpServer.listen(port, event -> {
            if(event.succeeded()){
                log.info("server started on port: " + port);
            }else {
                log.error("failed to start server, cause: {}", event.cause());
            }
        });
    }
}
