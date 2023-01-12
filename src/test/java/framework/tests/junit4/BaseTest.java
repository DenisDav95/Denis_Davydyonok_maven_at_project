package framework.tests.junit4;

import framework.driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void initDriver() {
//        WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));
    }

//    @AfterClass
//    public static void closeDriver() {
//        Driver.closeDriver();
//    }
}
