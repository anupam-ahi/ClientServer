package org.example;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            try {
                socket = serverSocket.accept();
                isr = new InputStreamReader(socket.getInputStream());
                osw = new OutputStreamWriter(socket.getOutputStream());
                br = new BufferedReader(isr);
                bw = new BufferedWriter(osw);

                while (true) {
                    String messageFromClient = br.readLine();
                    System.out.println("Client: " + messageFromClient);
                    bw.write("MSG recieved");
                    bw.newLine();
                    bw.flush();
                    if (messageFromClient.equalsIgnoreCase("BYE")) {
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
