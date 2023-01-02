package tech.altier.JProxyClient.API;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;

public class JProxyRequest implements Runnable {
    private final String request;

    public JProxyRequest(String request) {
        this.request = request;
        String host = "www.yourhost.com";
        Socket socket = new Socket(host, 80);


        InputStream is = socket.getInputStream();
        int ch;
        while( (ch=is.read())!= -1)
            System.out.print((char)ch);
        socket.close();
    }

    @Override
    public void run() {
        OutputStream os = socket.getOutputStream();
        os.write(request.getBytes());
        os.flush();
    }
}
