package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class DriverManager {

    public static WebDriver getDriver(Config config) {

        switch (config) {
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFirefoxDriver();
            default:
                throw null;
        }
    }

    public static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        return driver  ;
    }
}
