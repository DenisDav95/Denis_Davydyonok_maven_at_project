package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemogaTest {

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
    public void selectAll() {
        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.cssSelector("#withOptGroup")).click();
        driver.findElement(By.xpath("//div[@id='react-select-2-option-0-0']")).click();

        driver.findElement(By.cssSelector("#selectOne")).click();
        driver.findElement(By.xpath("//div[@id='react-select-3-option-0-1']")).click();

        driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option[@value='4']")).click();

        driver.findElement(By.xpath("//b[contains(text(), 'Multiselect drop down')]/../..//div[contains(@class, 'control')]")).click();
        driver.findElement(By.xpath("//div[@id='react-select-4-option-0']")).click();
        driver.findElement(By.xpath("//div[@id='react-select-4-option-1']")).click();

        driver.findElement(By.xpath("//option[@value='saab']")).click();
        driver.findElement(By.xpath("//option[@value='audi']")).click();
    }

    @After
    public void closeBrowse() {
        driver.close();
        driver.quit();
    }
}
