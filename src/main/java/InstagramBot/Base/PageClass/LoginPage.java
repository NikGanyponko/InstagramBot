package InstagramBot.Base.PageClass;

import InstagramBot.Base.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static InstagramBot.Base.Locators.get;

public class LoginPage {
    private static final String loginPageUrl = "https://www.instagram.com/accounts/login/";
    private static final By LOGIN_INPUT = get("LoginPage.LoginInput");
    private static final By PASSWORD_INPUT = get("LoginPage.PasswordInput");
    private static final By LOGIN_AUTHORIZATION_BUTTON = get("LoginPage.LoginAuthorizationBtn");

    public static void openLoginPage(WebDriver chromeDriver) {
        chromeDriver.get(loginPageUrl);
    }

    public static void openAccountUrl(WebDriver chromeDriver) {
        chromeDriver.get(loginPageUrl + Helper.getAccountLogin());
    }

    public static void setLoginInput (WebDriver chromeDriver) {
        chromeDriver.findElement(LOGIN_INPUT)
                .sendKeys(Helper.getAccountLogin());
    }

    public static void setPasswordInput (WebDriver chromeDriver) {
        chromeDriver.findElement(PASSWORD_INPUT)
                .sendKeys(Helper.getAccountPassword());
    }

    public static void clickAuthorizationBtn (WebDriver chromeDriver) {
        chromeDriver.findElement(LOGIN_AUTHORIZATION_BUTTON)
                .click();
    }

}
