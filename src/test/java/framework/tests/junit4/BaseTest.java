package framework.tests.junit4;

import framework.driver.Config;
import framework.driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeClass
    public static void initDriver() {
        WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));
    }

//    @AfterClass
//    public static void closeDriver() {
//        Driver.closeDriver();
//    }
}
