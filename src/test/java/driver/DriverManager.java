package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


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
        return new ChromeDriver(caps);
    }

    public static WebDriver getFirefoxDriver() {
        FirefoxOptions faps = new FirefoxOptions();
//        faps.addArguments("--width=1080");
//        faps.addArguments("--height=1080");
        return new FirefoxDriver(faps);
    }
}
