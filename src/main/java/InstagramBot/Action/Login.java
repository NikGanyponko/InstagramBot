package InstagramBot.Action;

import InstagramBot.Base.Helper;
import InstagramBot.Base.PageClass.LoginPage;
import org.openqa.selenium.WebDriver;

public class Login {

    public Login(WebDriver chromeDriver){
        LoginPage.openLoginPage(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
        LoginPage.setLoginInput(chromeDriver);
        LoginPage.setPasswordInput(chromeDriver);
        LoginPage.clickAuthorizationBtn(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
    }
}