package InstagramBot.Action;

import InstagramBot.Base.DataClass.DataUser;
import InstagramBot.Base.Helper;
import InstagramBot.Base.PageClass.ProfilePage;
import org.openqa.selenium.WebDriver;
import java.util.Iterator;

public class Profile {
    private int checkOfUnFollowers = 1;

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

        unFollowing(chromeDriver);
    }

    private void unFollowing(WebDriver chromeDriver) {
        Iterator<String> iterator = DataUser.getIteratorUnFollowingSet();

        while (iterator.hasNext()) {
            String login = iterator.next();
            cancelSubscriptions(login, chromeDriver);
        }
    }

    private void cancelSubscriptions(String login, WebDriver chromeDriver) {
        chromeDriver.get(ProfilePage.getUnFollowersUrl(login));
        Helper.checkAdditionalPages(chromeDriver);
        ProfilePage.clickSubcriptionText(chromeDriver);
        Helper.sleep(1500);
        ProfilePage.clickCancelSubscriptionBtn(chromeDriver);
        System.out.println("№ " + checkOfUnFollowers + " отписались от " + login);
        checkOfUnFollowers++;
    }
}