package framework.tests.junit4;

import framework.driver.Driver;
import framework.utils.L4JLogging;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static framework.utils.L4JLogging.LOGGER;

public class BaseTest {

    public static final Logger LOGGER =
            Logger.getLogger(BaseTest.class.getName());

    @BeforeClass
    public static void setupLogging() {
        LOGGER.info("Начало выполнения теста");
    }

    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
