package ajava.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("BIO Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try (InputStream input = clientSocket.getInputStream();
                     OutputStream output = clientSocket.getOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = input.read(buffer);
                    output.write(buffer, 0, bytesRead);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}