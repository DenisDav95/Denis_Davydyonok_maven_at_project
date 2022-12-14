package homework;

//        1. Перейти на сайт https://www.w3schools.com/java/
//        2. Двойным кликом выделить в заголовке слово Tutorial
//        3. Скопировать используя горячие клавиши Ctrl+c
//        4. Перейти на сайт https://google.com
//        5. Вставить в строку поиска скопированное
//        6. Запустить поиск клавишей Enter
//        7. Убедиться, что каждый из результатов содержит искомое слово

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TutorialTest {

    private static WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/java/");
    }

    @Test
    public void tutorialCheck() {

        WebElement title = driver.findElement(By.xpath("//span[@class='color_h1']"));
        Actions action = new Actions(driver);
        action
                .doubleClick(title)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 1000).until(
                ExpectedConditions.elementToBeClickable(By.name("q")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.name("q"));
        action
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        List<WebElement> titles = driver.findElements(By.xpath("//div[@data-header-feature='0']//h3"));

        List<String> allTitles = titles.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Assert.assertTrue("Некоторые результаты поиска не содержат искомое слово",
                allTitles.stream().allMatch(i -> i.contains("tutorial")));
    }

    @After
    public void closeBrowse() {
       driver.close();
       driver.quit();
    }
}
