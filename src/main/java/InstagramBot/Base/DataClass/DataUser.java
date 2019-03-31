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
    private static String mainPageSourceString;
    private static char[] mainPageMainChar;
    private static Matcher matcher;

    public static void setFollowers(WebDriver chromeDriver) {
        Helper.sleep(180000);
        setPageResource(chromeDriver);

        while (matcher.find()) {
            int i = matcher.end() + 1;
            String loginUser = "/";

            while (mainPageMainChar[i] != '/'){
                loginUser = loginUser + mainPageMainChar[i];
                i++;
            }
            followersSet.add(loginUser);
        }
    }

    public static void setUnFollowers(WebDriver chromeDriver) {
        Helper.sleep(180000);
        setPageResource(chromeDriver);

        while (matcher.find()) {
            int i = matcher.end() + 1;
            String loginUser = "/";

            while (mainPageMainChar[i] != '/'){
                loginUser = loginUser + mainPageMainChar[i];
                i++;
            }

            if (followersSet.add(loginUser)) {
                unFollowingSet.add(loginUser);
                System.out.println("№ " + unFollowingSet.size() + " не подписанный пользователь " + loginUser);
            }
        }
    }

    private static void setPageResource(WebDriver chromeDriver) {
       mainPageSourceString = chromeDriver.getPageSource()
                .substring(chromeDriver.getPageSource().indexOf("<main"), chromeDriver.getPageSource().indexOf("</main"));
       mainPageMainChar = mainPageSourceString.toCharArray();
       matcher = Pattern.compile("(href=\")").matcher(mainPageSourceString);
    }

    public static Iterator<String> getIteratorUnFollowingSet() {
        return unFollowingSet.iterator();
    }
}
