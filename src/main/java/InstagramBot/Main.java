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

    public static void startBot() {
        /* Open Chrome driver in a mobile */
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions().setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);

        /* Start bot */
        Helper.setAccountLogin("1");
        Helper.setAccountPassword("1");

        Login login = new Login(chromeDriver);
        //AccountInfo accountInfo = new AccountInfo(chromeDriver);
    }
}
