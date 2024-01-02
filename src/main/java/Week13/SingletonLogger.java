package Week13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingletonLogger {
    private static SingletonLogger instance;

    private SingletonLogger() {}

    public static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    private void logMessage(String severity, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());
        System.out.println("[" + formattedDate + "] [" + severity + "] " + message);
    }

    public void log(String message) {
        logMessage("INFO", message);
    }

    public void logInfo(String message) {
        logMessage("INFO", message);
    }

    public void logWarning(String message) {
        logMessage("WARNING", message);
    }

    public void logError(String message) {
        logMessage("ERROR", message);
    }

    public static void main(String[] args) {

        SingletonLogger logger = SingletonLogger.getInstance();

        logger.logInfo("Application started");
        logger.logWarning("Resource usage high");
        logger.logError("Critical error occurred");
        logger.logInfo("Application stopped");
    }
}
