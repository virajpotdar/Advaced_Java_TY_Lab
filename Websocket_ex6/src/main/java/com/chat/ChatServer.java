package com.chat;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint("/chat")
public class ChatServer {
    private static Set<Session> clients =
            Collections.synchronizedSet(new HashSet<>());
    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session)
            throws IOException {

        synchronized (clients) {

            for (Session client : clients) {

                if (client.isOpen()) {

                    client.getBasicRemote().sendText(message);
                }
            }
        }
    }


    @OnClose
    public void onClose(Session session) {

        clients.remove(session);

    }
}