package org.academiadecodigo.bootcamp;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {

        try {

            String message;
            String name;

            System.out.println("Trying to establishing the connection, please wait...");

            Socket clientSocket = new Socket("localhost", 9878);

            System.out.println("Connected to: " + clientSocket);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(reader);

            while (!clientSocket.isClosed()) {

                System.out.print("Username: ");
                name = bReader.readLine();
                out.println(name);

                message = bReader.readLine();
                out.println(message);

                if (message.equals("/quit")) {
                    System.out.println("Chat closed!");
                    clientSocket.close();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
