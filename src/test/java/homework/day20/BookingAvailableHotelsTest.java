package homework.day20;

//        1. Перейти на сайт booking.com
//        2. Ввести в поиск «Москва», выбрать для проживания 2 гостей и 1 номер.
//        3. Проверить, что в Москве есть отели на введенные даты

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookingAvailableHotelsTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkAvailableHotel() {
        driver.get("https://booking.com/");
        WebElement search = driver.findElement(By.cssSelector("input[name='ss']"));
        search.sendKeys("Milano");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue("Нет отелей на введенные даты", driver.findElement(By.cssSelector("h1[class]")).isDisplayed());
    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}
