package InstagramBot.Action;

import InstagramBot.Base.DataClass.DataUser;
import InstagramBot.Base.Helper;
import InstagramBot.Base.PageClass.ProfilePage;
import org.openqa.selenium.WebDriver;

public class Profile {

    public Profile(WebDriver chromeDriver) {
        ProfilePage.clickIconProfile(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);

        ProfilePage.clickFollowersProfile(chromeDriver);
        DataUser.setFollowers(chromeDriver);
        ProfilePage.openProfilePage(chromeDriver);

        Helper.checkAdditionalPages(chromeDriver);
        ProfilePage.clickIconProfile(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);

        ProfilePage.clickFollowingProfile(chromeDriver);
        Helper.checkAdditionalPages(chromeDriver);
        DataUser.setUnFollowers(chromeDriver);
    }
}