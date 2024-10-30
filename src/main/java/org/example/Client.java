package org.example;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws IOException {
        Socket client = new Socket("localhost", 8080);

    }

}
