package com.travelsky.aoc.pluginmanagerserver.fileserver;

import com.travelsky.aoc.pluginmanagerserver.fileserver.server.ClientSession;

import java.util.concurrent.ConcurrentHashMap;

public class ClientManager {

    private static final ConcurrentHashMap<String, ClientSession> serviceToClient = new ConcurrentHashMap<>(16);


    public static void put(String ip, String service, ClientSession session) {
        serviceToClient.put(ip + ":" + service, session);
    }

    public static ClientSession get(String ip, String service) {
        return serviceToClient.get(ip + ":" + service);
    }

}
