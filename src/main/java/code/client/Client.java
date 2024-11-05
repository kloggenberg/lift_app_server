package code.client;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server");

            // Read and display the welcome message from the server
            System.out.println("Server: " + in.readLine());

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                System.out.println("Server response: " + in.readLine());
            }

        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}