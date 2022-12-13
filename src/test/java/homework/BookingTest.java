package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

//        1. Перейти на сайт booking.com
//        2. Найти отели для города «Париж», с проживанием на 7 ночей заездом через 3 дня, для 4 взрослых в 2 номерах
//        3. Отфильтровать отели с максимальной стоимостью
//        4. Отсортировать по стоимости начиная с самого дешевого и проверить, что его стоимость ночи >= максимальной

public class BookingTest {

    private static WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://booking.com/");
    }

    @Test
    public void priceCheck() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE,3);
        String startDay = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, 7);
        String endDay = dateFormat.format(cal.getTime());

        try {
            driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
            WebElement addGuest = driver.findElement(By.xpath("//div[@class='sb-group__field sb-group__field-adults']//button[@data-bui-ref='input-stepper-add-button']"));
            addGuest.click();
            addGuest.click();
            WebElement addRoom = driver.findElement(By.xpath("//div[@class='sb-group__field sb-group__field-rooms']//button[@data-bui-ref='input-stepper-add-button']"));
            addRoom.click();
            driver.findElement(By.xpath("//div[@class='xp__dates-inner']")).click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
            WebElement addGuest = driver.findElement(By.xpath("//input[@id='group_adults']/../div[2]/button[2]"));
            addGuest.click();
            addGuest.click();
            WebElement addRoom = driver.findElement(By.xpath("//input[@id='no_rooms']/../div[2]/button[2]"));
            addRoom.click();
            driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
        }

        driver.findElement(By.xpath(String.format("//*[@data-date='%s']", startDay))).click();
        driver.findElement(By.xpath(String.format("//*[@data-date='%s']", endDay))).click();
        WebElement search = driver.findElement(By.xpath("//input[@name='ss']"));
        search.sendKeys("Париж");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Double pricePerDay = Double.parseDouble(driver.findElement(By.xpath("//div[@data-testid='filters-sidebar']" +
                "/div[2]//div[@data-filters-item='pri:pri=5']" +
                "//div[@data-testid='filters-group-label-content']"))
                        .getText()
                                .replaceAll("[^0-9]", ""));

        driver.findElement(By.xpath("//div[@data-testid='filters-sidebar']/div[2]//div[@data-filters-item='pri:pri=5']")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='price']")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Double priceHotel = Double.parseDouble(driver.findElement(By.xpath("//div[@data-block-id='hotel_list']" +
                        "//div[@data-testid='property-card'][1]" +
                        "//span[@data-testid='price-and-discounted-price']"))
                .getText()
                .replaceAll("[^0-9]", ""));

        Assert.assertTrue("Стоимость ночи в отеле меньше минимальной", priceHotel/7 >= pricePerDay);
    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}
