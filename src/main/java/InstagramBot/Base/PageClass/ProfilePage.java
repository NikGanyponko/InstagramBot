package InstagramBot.Base.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static InstagramBot.Base.Locators.get;

public class ProfilePage {
    private static final By ICON_PROFILE = get("ProfilePage.IconProfile");
    private static final By FOLLOWERS_OF_PROFILE = get("ProfilePage.FollowersOfProfile");
    private static final By FOLLOWING_OF_PROFILE = get("ProfilePage.FollowingOfProfile");

    public static void clickIconProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(ICON_PROFILE).click();
    }
    public static void clickFollowersProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(FOLLOWERS_OF_PROFILE).click();
    }
    public static void clickFollowingProfile(WebDriver chromeDriver) {
        chromeDriver.findElement(FOLLOWING_OF_PROFILE).click();
    }

}
