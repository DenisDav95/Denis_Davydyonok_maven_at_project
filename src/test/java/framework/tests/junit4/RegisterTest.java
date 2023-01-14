package framework.tests.junit4;

import framework.pages.BookingLoginPage;
import framework.pages.BookingPersonalDetailsPage;
import framework.pages.BookingRegisterPage;
import framework.pages.YopmailPage;
import framework.utils.ConfigProperties;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static framework.utils.L4JLogging.LOGGER;

public class RegisterTest extends BaseTest{

    private YopmailPage emailPage = new YopmailPage();
    private BookingRegisterPage registerPage = new BookingRegisterPage();
    private BookingLoginPage loginPage = new BookingLoginPage();
    private BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();



    @Test
    public void bookingRegistration() throws InterruptedException {

        try {
            registerPage.openPage();
            registerPage.inputEmail(ConfigProperties.getValue("emailName") +
                    ConfigProperties.getValue("emailDomain"));
            registerPage.clickSubmitButton();
            registerPage.inputPass(ConfigProperties.getValue("userPass"));
            registerPage.clickSubmitButton();
            LOGGER.info("Форма регистрации отправлена");
        } catch (Exception e) {
            LOGGER.error("Неудалось зарегестировать пользователя");
            return;
        }

        try {
            emailPage.openPage();
            emailPage.createEmail(ConfigProperties.getValue("emailName"));
            emailPage.findEmail();
            emailPage.acceptRegistration();
            LOGGER.info("Пройдена верификация email");
        } catch (Exception e) {
            LOGGER.error("Неудалось подтвердить регистрацию по email");
            return;
        }


        try {
            loginPage.openPage();
            loginPage.inputEmail(ConfigProperties.getValue("emailName") +
                    ConfigProperties.getValue("emailDomain"));
            loginPage.clickSubmitButton();
            loginPage.inputPass(ConfigProperties.getValue("userPass"));
            loginPage.clickSubmitButton();
            loginPage.closePopup();
            LOGGER.info("Вход в аккаунт выполнен успешно");
        } catch (Exception e) {
            LOGGER.error("Неудалось войти в аккаунт");
            return;
        }


        try {
            personalDetailsPage.openPage();
            LOGGER.info("Открыта страница с информацией о пользователе");
        } catch (Exception e) {
            LOGGER.error("Неудалось открыть страницу с информацией о пользователе");
            return;
        }

        Assert.assertTrue("Нет иконки подтверждения email адреса", personalDetailsPage.checkStatus());
    }
}
