package framework.pages;

import framework.driver.Config;
import framework.driver.Driver;
import framework.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class YopmailPage {

    WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));

    public void openPage(){
        driver.get(ConfigProperties.getValue("emailUrl"));
    }

    public void createEmail(String tempEmail) {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(tempEmail);
        driver.findElement(By.xpath("//button[@class='md']")).click();
    }

//    public void refreshMailbox() {
//        driver.findElement(By.id("refresh")).click();
//    }

    public Boolean checkEmail() {
        try {
            driver.findElement(By.xpath("//span[contains(text(),'Booking.com')]/../.."));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void findEmail() throws InterruptedException {
        int counter = 0;
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        while (!checkEmail()) {
            driver.switchTo().defaultContent();
            driver.findElement(By.id("refresh")).click();
            driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
//            driver.navigate().refresh();
            Thread.sleep(500);
            counter++;
            if(counter > 100) {
                return;
            }
        }
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
