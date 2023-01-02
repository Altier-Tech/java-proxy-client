package tech.altier.JProxyClient.API;

import java.io.IOException;

public class JProxyClient {
    public static void SendRequest(String request) throws IOException {
        Thread requestThread = new Thread(new JProxyRequest(request));
        requestThread.start();
    }
}
