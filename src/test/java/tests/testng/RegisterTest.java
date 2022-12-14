package tests.testng;

import pages.BookingLoginPage;
import pages.BookingPersonalDetailsPage;
import pages.BookingRegisterPage;
import pages.POYopmailPage;
import org.testng.annotations.Test;
import utils.ConfigProperties;

import static org.testng.AssertJUnit.*;

public class RegisterTest extends BaseTest{

    private POYopmailPage emailPage = new POYopmailPage();
    private BookingRegisterPage registerPage = new BookingRegisterPage();
    private BookingLoginPage loginPage = new BookingLoginPage();
    private BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();

    @Test
    public void bookingRegistration() throws InterruptedException {
        registerPage.openPage();
        registerPage.inputEmail(ConfigProperties.property.getProperty("emailName") +
                        ConfigProperties.property.getProperty("emailDomain"));
        registerPage.clickSubmitButton();
        registerPage.inputPass(ConfigProperties.property.getProperty("userPass"));
        registerPage.clickSubmitButton();

        emailPage.openPage();
        emailPage.createEmail(ConfigProperties.property.getProperty("emailName"));
        Thread.sleep(6000);
        emailPage.refreshMailbox();
        emailPage.findEmail();
        emailPage.acceptRegistration();

        loginPage.openPage();
        loginPage.inputEmail(ConfigProperties.property.getProperty("emailName") +
                ConfigProperties.property.getProperty("emailDomain"));
        loginPage.clickSubmitButton();
        loginPage.inputPass(ConfigProperties.property.getProperty("userPass"));
        loginPage.clickSubmitButton();
        loginPage.closePopup();

        personalDetailsPage.openPage();
        assertTrue("Нет иконки подтверждения email адреса", personalDetailsPage.checkStatus());
    }
}
