package tech.altier.JProxyClient.API;

import tech.altier.JProxyClient.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class JProxyRequest implements Runnable {
    private final String request;
    private Socket socket;
    private String response;

    public JProxyRequest(String request) throws IOException {
        this.request = request;
        socket = new Socket("", 80);
    }

    @Override
    public void run() {
        try (OutputStream os = socket.getOutputStream()) {
            os.write(request.getBytes());
            os.flush();
        } catch (Exception e) {
            Main.logger.error(e.getMessage());
        }

        StringBuilder responseBuilder = new StringBuilder();
        try (InputStream is = socket.getInputStream()) {
            int ch;
            while( (ch=is.read())!= -1) responseBuilder.append((char) ch);
        } catch (Exception e) {
            Main.logger.error(e.getMessage());
        }

        try {
            socket.close();
        } catch (IOException e) {
            Main.logger.error(e.getMessage());
        }

        response = responseBuilder.toString();
    }
}
