package driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    public static void closeDriver() {
        driver.quit();
    }

    public static WebDriver getDriver(Config config) {
        if (driver == null) {
            driver = DriverManager.getDriver(config);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
