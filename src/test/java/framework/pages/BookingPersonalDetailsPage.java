package framework.pages;

import framework.driver.Config;
import framework.driver.Driver;
import framework.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BookingPersonalDetailsPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage() {
        driver.get(ConfigProperties.getValue("bookingPersonalDetailsUrl"));
    }

    public Boolean checkStatus() {
        try {
            driver.findElement(By.xpath("//span[contains(text(), 'Verified')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
