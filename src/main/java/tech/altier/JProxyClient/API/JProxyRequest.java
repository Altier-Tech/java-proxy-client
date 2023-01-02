package tech.altier.JProxyClient.API;

import tech.altier.JProxyClient.Main;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;

public class JProxyRequest implements Runnable {
    private final String request;
    private Socket socket;

    public JProxyRequest(String request) {
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

        try (InputStream is = socket.getInputStream()) {
            int ch;
            while( (ch=is.read())!= -1) System.out.print((char)ch);
        } catch (Exception e) {
            Main.logger.error(e.getMessage());
        }

        socket.close();
    }
}
