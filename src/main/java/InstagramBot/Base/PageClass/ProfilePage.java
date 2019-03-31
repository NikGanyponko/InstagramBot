package InstagramBot.Base.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static InstagramBot.Base.Locators.get;

public class ProfilePage {
    private static final String loginPageUrl = "https://www.instagram.com/accounts/login/";
    private static final By ICON_PROFILE = get("ProfilePage.IconProfile");
    private static final By FOLLOWERS_OF_PROFILE = get("ProfilePage.FollowersOfProfile");
    private static final By FOLLOWING_OF_PROFILE = get("ProfilePage.FollowingOfProfile");
    private static final By SUBSCRIPTION_TEXT = get("ProfilePage.SubscriptionText");
    private static final By CANCEL_SUBSCRIPTION_BUTTON = get("ProfilePage.cancelSubscriptionBtn");

    public static void clickIconProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(ICON_PROFILE).click();
    }
    public static void clickFollowersProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(FOLLOWERS_OF_PROFILE).click();
    }
    public static void clickFollowingProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(FOLLOWING_OF_PROFILE).click();
    }

    public static void openProfilePage(WebDriver chromeDriver) {
        chromeDriver.get(loginPageUrl);
    }

    public static void clickSubcriptionText(WebDriver chromeDriver) {
        chromeDriver.findElement(SUBSCRIPTION_TEXT).click();
    }

    public static void clickCancelSubscriptionBtn(WebDriver chromeDriver) {
        chromeDriver.findElement(CANCEL_SUBSCRIPTION_BUTTON).click();
    }

}
