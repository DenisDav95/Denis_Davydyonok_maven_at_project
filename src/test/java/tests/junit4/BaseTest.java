package tests.junit4;

import driver.Config;
import driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeClass
    public static void initDriver() {
        ConfigProperties.initPropertyFile();
        WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
