package Sample.Logging.Configuring_Logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {
    private static final Logger logger = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();

        consoleHandler.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);

        logger.info("This is an Information message");
        logger.warning("This is a warning message.");
        logger.severe("This is a severe message.");
    }
}
