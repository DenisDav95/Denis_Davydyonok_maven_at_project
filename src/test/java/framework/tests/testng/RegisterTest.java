package framework.tests.testng;

import framework.pages.BookingLoginPage;
import framework.pages.BookingPersonalDetailsPage;
import framework.pages.BookingRegisterPage;
import framework.pages.YopmailPage;
import framework.utils.ConfigProperties;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class RegisterTest extends BaseTest{

    private YopmailPage emailPage = new YopmailPage();
    private BookingRegisterPage registerPage = new BookingRegisterPage();
    private BookingLoginPage loginPage = new BookingLoginPage();
    private BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();

    @Test
    public void bookingRegistration() throws InterruptedException {
        registerPage.openPage();
        registerPage.inputEmail(ConfigProperties.getValue("emailName") +
                ConfigProperties.getValue("emailDomain"));
        registerPage.clickSubmitButton();
        registerPage.inputPass(ConfigProperties.getValue("userPass"));
        registerPage.clickSubmitButton();

        emailPage.openPage();
        emailPage.createEmail(ConfigProperties.getValue("emailName"));
//        Thread.sleep(6000);
//        emailPage.refreshMailbox();
        emailPage.findEmail();
        emailPage.acceptRegistration();

        loginPage.openPage();
        loginPage.inputEmail(ConfigProperties.getValue("emailName") +
                ConfigProperties.getValue("emailDomain"));
        loginPage.clickSubmitButton();
        loginPage.inputPass(ConfigProperties.getValue("userPass"));
        loginPage.clickSubmitButton();
        loginPage.closePopup();

        personalDetailsPage.openPage();
        assertTrue("Нет иконки подтверждения email адреса", personalDetailsPage.checkStatus());
    }
}
