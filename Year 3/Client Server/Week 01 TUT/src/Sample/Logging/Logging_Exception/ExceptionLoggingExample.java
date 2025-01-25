package Sample.Logging.Logging_Exception;

import java.util.logging.Logger;

public class ExceptionLoggingExample {
    private static final Logger logger = Logger.getLogger(ExceptionLoggingExample.class.getName());

    public static void main(String[] args) {
        try{
            throw new RuntimeException("This is a sample exception");
        }
        catch (Exception e){
            logger.severe("An exception occurred " + e.getMessage());
            logger.severe("Stack trace: ");
            for(StackTraceElement element: e.getStackTrace()){
                logger.severe(element.toString());
            }
        }
    }
}
