package pages;

import driver.Config;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperties;

public class BookingPersonalDetailsPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage() {
        driver.get(ConfigProperties.property.getProperty("bookingPersonalDetailsUrl"));
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
