package tech.altier.JProxyClient.API;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class JProxyClient {
    private static final String SERVER_ADDRESS;

    static {
        SERVER_ADDRESS = "http://localhost:8080";   // TODO load this from application.properties
    }

    public static void sendRequest(String request) throws IOException {
        Thread requestThread = new Thread(new JProxyRequest(request));
        requestThread.start();
    }

    public static String send(String request) throws IOException {
        URL url = new URL(SERVER_ADDRESS);   // TODO load this from application.properties
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        request = buildRequestBody(request);

        byte[] out = request.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
//        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        InputStream is = http.getInputStream();
        return new String(is.readAllBytes());
    }

    private static String buildRequestBody(String endpoint) {
        return  "{\n" +
                "  \"method\": \"GET\",\n" +
                "  \"endpoint\": \"" + endpoint + "\",\n" +
                "  \"version\": \" HTTP/1.1\",\n" +
                "  \"body\": \"\"\n" +
                "}";
    }
}
