package framework.tests.junit4;

import framework.driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static framework.utils.L4JLogging.LOGGER;

public class BaseTest {

    @BeforeClass
    public static void setupLogging() {
        LOGGER.info("Начало выполнения теста");
    }

    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
