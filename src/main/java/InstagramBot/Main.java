package InstagramBot;

import InstagramBot.Base.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.createUi();
    }

    public static void startBot(String login, String password) {

        Helper.setAccountLogin(login);
        Helper.setAccountPassword(password);
        Helper.createChromeDriver();

        /* Start bot */
        Helper.setAccountLogin(Helper.getAccountLogin());
        Helper.setAccountPassword(Helper.getAccountPassword());

        Login loginClass = new Login(Helper.getChromeDriver());
        //AccountInfo accountInfo = new AccountInfo(chromeDriver);
    }
}
