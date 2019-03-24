package InstagramBot;

import InstagramBot.Action.Login;
import InstagramBot.Action.Profile;
import InstagramBot.Base.Helper;

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
        Profile profileClass = new Profile(Helper.getChromeDriver());
        //AccountInfo accountInfo = new AccountInfo(chromeDriver);
    }
}
