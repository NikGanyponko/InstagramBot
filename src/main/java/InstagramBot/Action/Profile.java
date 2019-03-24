package InstagramBot.Action;

import InstagramBot.Base.Helper;
import InstagramBot.Base.PageClass.ProfilePage;
import org.openqa.selenium.WebDriver;

public class Profile {

    public Profile(WebDriver chromeDriver) {
        ProfilePage.clickIconProfile(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
        ProfilePage.clickFollowersProfile(chromeDriver);
        System.out.println(chromeDriver.getPageSource());
    }
}
