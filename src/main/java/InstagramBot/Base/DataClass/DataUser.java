package InstagramBot.Base.DataClass;

import InstagramBot.Base.Helper;
import org.openqa.selenium.WebDriver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUser {
    public static HashSet<String> followersSet = new HashSet<String>();
    public static HashSet<String> unFollowingSet = new HashSet<String>();

    public static void setFollowers(WebDriver chromeDriver) {
        Helper.sleep(180000);
        String pageSource = chromeDriver.getPageSource();
        String mainPageMainString = pageSource.substring(pageSource.indexOf("<main"), pageSource.indexOf("</main"));
        char[] mainPageMainChar = mainPageMainString.toCharArray();

        Matcher matcher = Pattern.compile("(href=\")").matcher(mainPageMainString);

        while (matcher.find()) {
            int i = matcher.end() + 1;

            String loginUser = "/";
            char endOfLogin = '/';

            while (mainPageMainChar[i] != endOfLogin){
                loginUser = loginUser + mainPageMainChar[i];
                i++;
            }
            followersSet.add(loginUser);
        }
    }

    public static void setUnFollowers(WebDriver chromeDriver) {
        Helper.sleep(180000);
        String pageSource = chromeDriver.getPageSource();
        String mainPageMainString = pageSource.substring(pageSource.indexOf("<main"), pageSource.indexOf("</main"));
        char[] mainPageMainChar = mainPageMainString.toCharArray();

        Matcher matcher = Pattern.compile("(href=\")").matcher(mainPageMainString);

        while (matcher.find()) {
            int i = matcher.end() + 1;

            String loginUser = "/";
            char endOfLogin = '/';

            while (mainPageMainChar[i] != endOfLogin){
                loginUser = loginUser + mainPageMainChar[i];
                i++;
            }

            if (followersSet.add(loginUser)) {
                unFollowingSet.add(loginUser);
                System.out.println("№ " + unFollowingSet.size() + " не подписанный пользователь " + loginUser);
            }
        }
    }

    public static Iterator<String> getIteratorUnFollowingSet() {
        return unFollowingSet.iterator();
    }
}
