package steps;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BookingLoginPage;
import pages.BookingPersonalDetailsPage;
import pages.BookingRegisterPage;
import pages.POYopmailPage;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;


public class BookingRegisterSteps {

    private POYopmailPage emailPage = new POYopmailPage();
    private BookingRegisterPage registerPage = new BookingRegisterPage();
    private BookingLoginPage loginPage = new BookingLoginPage();
    private BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();

    @Before
    public static void initDriver() {
        ConfigProperties.initPropertyFile();
        WebDriver driver = Driver.getDriver(Config.valueOf(System.getenv("BROWSER")));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Given("I register a new user")
    public void registerUser() {
        registerPage.openPage();
        registerPage.inputEmail(ConfigProperties.property.getProperty("emailName") +
                ConfigProperties.property.getProperty("emailDomain"));
        registerPage.clickSubmitButton();
        registerPage.inputPass(ConfigProperties.property.getProperty("userPass"));
        registerPage.clickSubmitButton();
        throw new cucumber.api.PendingException();
    }

    @When("I confirm email address")
    public void confirmEmail() throws InterruptedException {
        emailPage.openPage();
        emailPage.createEmail(ConfigProperties.property.getProperty("emailName"));
        Thread.sleep(6000);
        emailPage.refreshMailbox();
        emailPage.findEmail();
        emailPage.acceptRegistration();
        throw new cucumber.api.PendingException();
    }

    @When("I login as user")
    public void loginUser() {
        loginPage.openPage();
        loginPage.inputEmail(ConfigProperties.property.getProperty("emailName") +
                ConfigProperties.property.getProperty("emailDomain"));
        loginPage.clickSubmitButton();
        loginPage.inputPass(ConfigProperties.property.getProperty("userPass"));
        loginPage.clickSubmitButton();
        loginPage.closePopup();
        throw new cucumber.api.PendingException();
    }

    @Then("I verify that mailbox was confirmed")
    public void doAssert() {
        personalDetailsPage.openPage();
        Assert.assertTrue("Нет иконки подтверждения email адреса", personalDetailsPage.checkStatus());
        throw new cucumber.api.PendingException();
    }

    @After
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
