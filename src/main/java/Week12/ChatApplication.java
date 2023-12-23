package Week12;

public class ChatApplication {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(54321); // Start the server on the specified port
    }
}
