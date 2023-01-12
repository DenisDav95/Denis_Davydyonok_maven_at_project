package framework.tests.testng;

import framework.driver.Config;
import framework.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
