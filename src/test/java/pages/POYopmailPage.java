package pages;

import driver.Config;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperties;

import java.util.ArrayList;

public class POYopmailPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage(){
        driver.get(ConfigProperties.property.getProperty("emailUrl"));
    }

    public void createEmail(String tempEmail) {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(tempEmail);
        driver.findElement(By.xpath("//button[@class='md']")).click();
    }

    public void refreshMailbox() {
        driver.findElement(By.id("refresh")).click();
    }

    public void findEmail() {
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        driver.findElement(By.xpath("//span[contains(text(),'Booking.com')]/../..")).click();
        driver.switchTo().defaultContent();
    }

    public void acceptRegistration() {
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        driver.findElement(By.xpath("//a[contains(text(),'Confirm')]")).click();
        driver.switchTo().defaultContent();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
