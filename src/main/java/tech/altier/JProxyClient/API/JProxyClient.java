package tech.altier.JProxyClient.API;

public class JProxyClient {
    public static void SendRequest(String reqest) {
        Thread requestThread = new Thread(new JProxyRequest(reqest));
    }
}
