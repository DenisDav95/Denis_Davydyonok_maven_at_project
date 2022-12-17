package homework;

//        1. Перейти на сайт booking.com
//        2. Ввести в поиск «Москва», выбрать для проживания 2 гостей и 1 номер.
//        3. Отфильтровать отели с максимальным рейтингом
//        4. Открыть страницу с первым таким отелем и проверить, что его рейтинг >=9

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BookingRatingHotelTest {

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
    public void ratingCheck() {
        driver.get("https://booking.com/");
        WebElement search = driver.findElement(By.cssSelector("input[name='ss']"));
        search.sendKeys("Milano");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[contains(@data-id,'score')]")).click();
//        driver.findElement(By.xpath("//button[@data-id='upsort_bh']")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//       WebElement sorterByScore = driver.findElement(By.xpath("//button[contains(@data-id,'score')]"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", sorterByScore);
//        Actions action = new Actions(driver);
//        action
//                .click(sorterByScore)
//                .build()
//                .perform();

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[contains(@data-id,'score')]")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@data-block-id='hotel_list']//div[@data-testid='property-card'][1]//h3")).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        double rate = Double.parseDouble(driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div"))
                .getText()
                .replace(',', '.'));

        Assert.assertTrue("Рейтинг отеля менее 9.0", rate >= 9.0);

    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}