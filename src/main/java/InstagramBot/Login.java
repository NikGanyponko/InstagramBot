package InstagramBot;

import InstagramBot.Base.Helper;
import InstagramBot.Base.PageClass.LoginPage;
import org.openqa.selenium.WebDriver;

public class Login {

    public Login(WebDriver chromeDriver){
        LoginPage.openLoginPage(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
        LoginPage.findLoginInput(chromeDriver);
        LoginPage.findPasswordInput(chromeDriver);
        LoginPage.clickAuthorizationBtn(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
    }
}