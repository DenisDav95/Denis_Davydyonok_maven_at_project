package tests.testng;

import pages.VoidBookingLoginPage;
import pages.VoidBookingPersonalDetailsPage;
import pages.VoidBookingRegisterPage;
import pages.VoidPOYopmailPage;
import org.testng.annotations.Test;
import settings.ConfigProperties;
import static org.testng.AssertJUnit.*;

public class RegisterTest extends BaseTest {

    private VoidPOYopmailPage emailPage = new VoidPOYopmailPage();
    private VoidBookingRegisterPage registerPage = new VoidBookingRegisterPage();
    private VoidBookingLoginPage loginPage = new VoidBookingLoginPage();
    private VoidBookingPersonalDetailsPage personalDetailsPage = new VoidBookingPersonalDetailsPage();

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
