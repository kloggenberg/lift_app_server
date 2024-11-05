package code.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import code.config.Config;

public class Server {
    public static void main(String[] args) {
        int port = Config.SERVER_PORT;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Start a new thread for each client connection
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}
