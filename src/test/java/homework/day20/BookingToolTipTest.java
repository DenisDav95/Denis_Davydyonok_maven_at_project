package homework.day20;

//        1. Перейти на сайт https://booking.com
//        2. Навести мышь на индикатор валюты
//        3. Проверить значение подсказки
//        4. Навести мышь на индикатор языка
//        5. Проверить значение подсказки

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BookingToolTipTest {

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
    public void toolTipCheck() {
        driver.get("https://booking.com/");
        Actions actions = new Actions(driver);

        WebElement currency = driver.findElement(By.xpath("//button[contains(@data-modal-header-async-type, 'currencyDesktop')]"));
        actions
                .moveToElement(currency)
                .build()
                .perform();
        Assert.assertEquals("Текст подсказики для валюты неправильный", "Выберите валюту" , currency.getAttribute("data-tooltip-text"));

        WebElement language = driver.findElement(By.xpath("//button[@data-modal-id]"));
        actions
                .moveToElement(language)
                .build()
                .perform();
        Assert.assertEquals("Текст подсказики для языка неправильный", "Выберите язык" , language.getAttribute("data-tooltip-text"));

    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}
