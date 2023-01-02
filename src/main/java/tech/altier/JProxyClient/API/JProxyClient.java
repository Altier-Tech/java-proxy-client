package tech.altier.JProxyClient.API;

public class JProxyClient {
    public static void SendRequest(String request) {
        Thread requestThread = new Thread(new JProxyRequest(request));
    }
}
