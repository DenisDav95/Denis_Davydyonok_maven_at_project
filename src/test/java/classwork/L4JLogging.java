package classwork;

import org.apache.log4j.Logger;

public class L4JLogging {

    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());

    public static void main(String[] args) {

        LOGGER.fatal("Сообщение с уровнем FATAL");
        LOGGER.error("Сообщение с уровнем ERROR");
        LOGGER.warn("Сообщение с уровнем WARNING");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");
    }
}
