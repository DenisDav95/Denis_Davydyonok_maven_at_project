package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//        1. Перейти на сайт booking.com
//        2. Найти отели для города «London»
//        2. Проскролить страницу к 10-му отелю сверху
//        3. Изменить цвет фона на зеленый, а цвет текста названия на красный
//        4. Проверить, что название красного цвета

public class BookingColorTest {

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
    public void colorCheck() {

        driver.get("https://booking.com/");
        WebElement search = driver.findElement(By.xpath("//input[@name='ss']"));
        search.sendKeys("London");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement hotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotel);

        WebElement title = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]//div[@data-testid='title']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", title);
        String color = title.getAttribute("style");
        Assert.assertEquals("Цвет названия не красного цвета", "color: red;", color);
    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}
