package classwork.day19;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DefaultLogging {

    private static final Logger LOGGER =
            Logger.getLogger(DefaultLogging.class.getName());

    public static void main(String[] args) throws IOException {
        FileInputStream configFile = new
                FileInputStream("src/test/resources/log.config");
        LogManager.getLogManager().readConfiguration(configFile);
        LOGGER.setLevel(Level.ALL);

        LOGGER.log(Level.SEVERE,"Сообщение с уровнем SEVERE");
        LOGGER.log(Level.WARNING,"Сообщение с уровнем WARNING");
        LOGGER.log(Level.INFO,"Сообщение с уровнем INFO");
        LOGGER.log(Level.CONFIG,"Сообщение с уровнем CONFIG");
        LOGGER.log(Level.FINE,"Сообщение с уровнем FINE");
        LOGGER.log(Level.FINER,"Сообщение с уровнем FINER");
        LOGGER.log(Level.FINEST,"Сообщение с уровнем FINEST");
        LOGGER.log(Level.ALL,"Сообщение с уровнем ALL");

    }


}
