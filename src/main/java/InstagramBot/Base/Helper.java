package InstagramBot.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static InstagramBot.Base.Locators.get;

public class Helper {
    private static WebDriver chromeDriver;
    private static String accountLogin;
    private static String accountPassword;
    private static final By ADD_INST_TEXT = get("AdditionalPages.AddInstToMainScreenText");
    private static final By CANCEL_ADD_INST_BUTTON = get("AdditionalPages.CancelAddInstToMainScreenBtn");
    private static final By SAVE_DATA_AUTH_TEXT = get("AdditionalPages.SaveDataAuthText");
    private static final By CANCEL_SAVE_DATA_AUTH_BUTTON = get("AdditionalPages.CancelSaveDataAuthBtn");
    private static final By ENABLE_NOTIFICATION_TEXT = get("AdditionalPages.EnableNotificationText");
    private static final By DISABLE_NOTIFICATION_BUTTON = get("AdditionalPages.DisableNotificationBtn");

    public static void checkAdditionalPages(WebDriver chromeDriver) {
        sleep(1500);
        checkAddInstToMainWindow(chromeDriver);
        checkSaveDataAuth(chromeDriver);
        checkEnableNotification(chromeDriver);
    }


    private static void checkAddInstToMainWindow(WebDriver chromeDriver) {
        if (checkElementExistOnPage(chromeDriver, ADD_INST_TEXT)) {
            chromeDriver.findElement(CANCEL_ADD_INST_BUTTON).click();
            checkAdditionalPages(chromeDriver);
        }
    }

    private static void checkSaveDataAuth(WebDriver chromeDriver) {
        if (checkElementExistOnPage(chromeDriver, SAVE_DATA_AUTH_TEXT)) {
            chromeDriver.findElement(CANCEL_SAVE_DATA_AUTH_BUTTON).click();
            checkAdditionalPages(chromeDriver);
        }
    }

    private static void checkEnableNotification(WebDriver chromeDriver) {
        if (checkElementExistOnPage(chromeDriver, ENABLE_NOTIFICATION_TEXT)) {
            chromeDriver.findElement(DISABLE_NOTIFICATION_BUTTON).click();
            checkAdditionalPages(chromeDriver);
        }
    }

    private static Boolean checkElementExistOnPage(WebDriver chromeDriver, By locator) {
        try {
            chromeDriver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void createChromeDriver() {
        if (chromeDriver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "Nexus 5");

            ChromeOptions chromeOptions = new ChromeOptions().setExperimentalOption("mobileEmulation", mobileEmulation);
            chromeDriver = new ChromeDriver(chromeOptions);
            chromeDriver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
        }
    }

    public static WebDriver getChromeDriver(){
        if (chromeDriver == null) {
            createChromeDriver();
            return chromeDriver;
        } else {
            return chromeDriver;
        }
    }

    public static void sleep() {
        try{
            Random random = new Random();
            int milliSeconds = (random.nextInt(7)*1000 + 1000);
            System.out.println("Торзмозимся на : " + milliSeconds/1000);
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) { }
    }

    public static void sleep(int milliSeconds) {
        try{
            System.out.println("Торзмозимся на : " + milliSeconds/1000);
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) { }
    }

    public static String getAccountLogin() {
        return accountLogin;
    }

    public static String getAccountPassword() {
        return accountPassword;
    }

    public static void setAccountLogin(String accountLogin) {
        Helper.accountLogin = accountLogin;
    }

    public static void setAccountPassword(String accountPassword) {
        Helper.accountPassword = accountPassword;
    }

}
