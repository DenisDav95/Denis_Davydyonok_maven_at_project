package pages;

import driver.Config;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperties;

public class BookingLoginPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage() {
        driver.get(ConfigProperties.property.getProperty("bookingLoginUrl"));
    }

    public void inputEmail(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
    }

    public void inputPass(String pass) {
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    public void clickSubmitButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void closePopup() {
        driver.findElement(By.xpath("//button[@title='Close']")).click();
    }
}
