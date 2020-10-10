package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {

        String message;
        String userName;

        try {

            System.out.println("Binding to port 9778.");

            ServerSocket serverSocket = new ServerSocket(9878);

            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client connection...");

            Socket clientSocket = serverSocket.accept();

            System.out.println("Client Connected: " + clientSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (!clientSocket.isClosed()) {

                userName = in.readLine();

                message = in.readLine();
                System.out.println(userName + ": " + message);

                if (message.equals("/quit")) {
                    System.out.println("Closing the connection...");
                    clientSocket.close();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
