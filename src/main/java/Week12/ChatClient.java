package Week12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: <username> <server-ip>");
            System.exit(1);
        }

        String username = args[0];
        String serverIP = args[1];
        int serverPort = 12345; // Specify the desired port number

        try {
            Socket socket = new Socket(serverIP, serverPort);

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);

            // Send username to the server
            serverWriter.println(username);

            // Start a new thread to continuously receive messages from the server
            new Thread(() -> {
                try {
                    String message;
                    while ((message = serverReader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read messages from the console and send them to the server
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userMessage;
            while ((userMessage = consoleReader.readLine()) != null) {
                serverWriter.println(userMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
