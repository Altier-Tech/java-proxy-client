package tech.altier.JProxyClient.API;

import java.net.HttpURLConnection;

public class JProxyRequest implements Runnable {
    private final String request;
    HttpURLConnection connection = null;

    public JProxyRequest(String request) {
        this.request = request;
    }

    @Override
    public void run() {

    }
}
