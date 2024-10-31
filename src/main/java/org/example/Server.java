package org.example;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        private final ServerSocket server;
        private DataInputStream in;
        static final int PORT = 8080;
        public Server() throws IOException {
            server = new ServerSocket(PORT);
            initializeConnection();
        }
        private void initializeConnection() throws IOException {
            Socket clientSocket = server.accept();
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            readClientMessages();
            closeConnection();
        }
        private void readClientMessages() throws IOException {
            String line;
            while ((line = in.readUTF()) != null) {
                line = line.trim();
                System.out.println(line);
            }
        }
        private void closeConnection() throws IOException {
            if(in != null) {
                in.close();
            }
            if(server != null && !server.isClosed()) {
                server.close();
            }
        }
    public static void main(String[] args) throws IOException {
            new Server();
    }
}
