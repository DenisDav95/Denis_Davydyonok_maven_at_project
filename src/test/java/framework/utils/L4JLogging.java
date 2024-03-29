package framework.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class L4JLogging {

    public static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());

    public static void main(String[] args) {

//        String log4jConfPath = "src/test/resources/framework/settings/log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);

        LOGGER.fatal("Сообщение с уровнем FATAL1111");
        LOGGER.error("Сообщение с уровнем ERROR2222");
        LOGGER.warn("Сообщение с уровнем WARNING3333");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");
    }
}
