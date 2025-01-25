package Sample.Logging.BasicLogging;

import java.util.logging.Logger;

public class SimpleLoggingExample {

    private static final Logger logger = Logger.getLogger(SimpleLoggingExample.class.getName());

    public static void main(String[] args) {
        logger.info("This is an Information Message");
        logger.warning("This is a warning message");
        logger.severe("This is a severe message");
    }
}
