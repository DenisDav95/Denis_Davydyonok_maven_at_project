package classwork.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class L4JLogging {

    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());

    public static void main(String[] args) {

        String log4jConfPath = "src/test/resources/classwork/logging/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        LOGGER.fatal("Сообщение с уровнем FATAL");
        LOGGER.error("Сообщение с уровнем ERROR");
        LOGGER.warn("Сообщение с уровнем WARNING");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");
    }
}
