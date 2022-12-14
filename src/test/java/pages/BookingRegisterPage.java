package pages;

import driver.Config;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigProperties;

public class BookingRegisterPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage() {
        String url = ConfigProperties.property.getProperty("bookingRegisterUrl");
        driver.get(ConfigProperties.property.getProperty("bookingRegisterUrl"));
    }

    public void inputEmail(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
    }

    public void clickSubmitButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void inputPass(String pass) {
        driver.findElement(By.id("new_password")).sendKeys(pass);
        driver.findElement(By.id("confirmed_password")).sendKeys(pass);
    }
}
