package tech.altier.JProxyClient.API;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class JProxyClient {
    public static void sendRequest(String request) throws IOException {
        Thread requestThread = new Thread(new JProxyRequest(request));
        requestThread.start();
    }

    public static void send(String request) throws IOException {
        URL url = new URL("https://www.example.com/login");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        byte[] out = request.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        InputStream is = http.getInputStream();
        String response = new String(is.readAllBytes());
    }
}
