package Week8;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class Events {
    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private static final int TOTAL_RECORDS = 1000000;

    public static void generateEventsFile(String filename)throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < TOTAL_RECORDS; i++) {

                String timestamp = generateRandomTimestamp();
                String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];
                int userId = random.nextInt(1000);

                writer.write(timestamp + " / Event Type: " + eventType + " / User ID: " + userId);
                writer.newLine();
            }
        }
    }

    private static String generateRandomTimestamp() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(new Random().nextInt(100)); // random time within reasonable bound (I think)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static void readEventsFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int iteration = 0;
            String line;
            while ((line = reader.readLine()) != null && iteration<5) {
                System.out.println(line);
            }
            if (!reader.ready()) { // ?? help
                iteration++;
            }
        }
    }

    public static void main(String[] args) {
        String filename = "events.txt";

        try{
            generateEventsFile(filename);
            readEventsFile(filename);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
