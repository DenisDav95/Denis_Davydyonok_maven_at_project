package framework.pages;

import framework.driver.Config;
import framework.driver.Driver;
import framework.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingLoginPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage() {
        driver.get(ConfigProperties.getValue("bookingLoginUrl"));
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
        driver.findElement(By.xpath("//button[@aria-label='Dismiss']")).click();
    }
}
