package framework.steps;

import framework.driver.Config;
import framework.driver.Driver;
import framework.utils.ConfigProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import framework.pages.BookingLoginPage;
import framework.pages.BookingPersonalDetailsPage;
import framework.pages.BookingRegisterPage;
import framework.pages.YopmailPage;

public class BookingRegisterSteps {

    private YopmailPage emailPage = new YopmailPage();
    private BookingRegisterPage registerPage = new BookingRegisterPage();
    private BookingLoginPage loginPage = new BookingLoginPage();
    private BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();

    @Before
    public static void initDriver() {

    }

    @Given("I register a new user")
    public void registerUser() {
        registerPage.openPage();
        registerPage.inputEmail(ConfigProperties.getValue("emailName") +
                ConfigProperties.getValue("emailDomain"));
        registerPage.clickSubmitButton();
        registerPage.inputPass(ConfigProperties.getValue("userPass"));
        registerPage.clickSubmitButton();
    }

    @When("I confirm email address")
    public void confirmEmail() throws InterruptedException {
        emailPage.openPage();
        emailPage.createEmail(ConfigProperties.getValue("emailName"));
        emailPage.findEmail();
        emailPage.acceptRegistration();
    }

    @When("I login as user")
    public void loginUser() {
        loginPage.openPage();
        loginPage.inputEmail(ConfigProperties.getValue("emailName") +
                ConfigProperties.getValue("emailDomain"));
        loginPage.clickSubmitButton();
        loginPage.inputPass(ConfigProperties.getValue("userPass"));
        loginPage.clickSubmitButton();
        loginPage.closePopup();
    }

    @Then("I verify that mailbox was confirmed")
    public void doAssert() {
        personalDetailsPage.openPage();
        Assert.assertTrue("Нет иконки подтверждения email адреса", personalDetailsPage.checkStatus());
    }

    @After
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
