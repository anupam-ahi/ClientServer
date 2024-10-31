package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket client;
    private DataOutputStream out;
    public Client() {
        try{
            client = new Socket("localhost", Server.PORT);
            out = new DataOutputStream(client.getOutputStream());
            writeMessages();
        }catch (IOException e){}
    }
    public void writeMessages() throws IOException {
        String message = "Hello, I am Anupam. ";
        out.writeUTF(message);
    }
    private void close() throws IOException {
        client.close();
        out.close();
    }
    public static void main(String[] args)  throws IOException {
        new Client();
    }
}
