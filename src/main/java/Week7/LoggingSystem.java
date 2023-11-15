package Week7;

import com.mysql.cj.log.Log;

interface Logger{
    void logMessage(String message);
}
record RecordLogger(String loggerName) implements Logger{

        @Override
        public void logMessage(String message){
            System.out.println("["+loggerName+"] "+message);
        }
}
class ClassLogger implements Logger{
    private String classLoggerName;

    public ClassLogger(String classLoggerName){
        this.classLoggerName=classLoggerName;
    }
    @Override
    public void logMessage(String message){
        System.out.println("["+classLoggerName+"] "+message);
    }
}
public class LoggingSystem {

    public static void main(String[] args) {

        Logger recordLogger = (String message) -> new RecordLogger("RecordLogger").logMessage(message);
        recordLogger.logMessage("Record");
        Logger classLogger = (String message) -> new ClassLogger("ClassLogger").logMessage(message);
        classLogger.logMessage("Class");
    }}
