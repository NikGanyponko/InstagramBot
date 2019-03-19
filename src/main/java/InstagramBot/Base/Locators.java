package InstagramBot.Base;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Locators {

    private static final Properties locatorsProperties;
    /**
     * Legend for the using at a resource file with locators:
     *  (<enum> - <text value>) ID - id, NAME - name, CSS - css, XPATH - xpath, TAG - tag, TEXT - text, PART_TEXT - partText
     */
    private enum LocatorType{
        ID, NAME, CSS, XPATH, TAG, TEXT, PART_TEXT, CLASS
    }

    static {
        locatorsProperties = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/Locator.properties");
        try {
            locatorsProperties.load(new InputStreamReader(is, Charset.forName("UTF-8")));
        }
        catch (Exception e) {
            System.out.println("Something wrong with the file 'locators.properties'." + e.getMessage());
        }
    }

    public static By get(String locatorName) {
        String propertyValue = locatorsProperties.getProperty(locatorName);
        By locator = getLocator(propertyValue);
        return locator;
    }

    private static By getLocator(String locator){
        String[] locatorItems = locator.split("=",2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0].toUpperCase());

        switch(locatorType) {

            case ID :
                return By.id(locatorItems[1]);

            case NAME:
                return By.name(locatorItems[1]);

            case CSS:
                return By.cssSelector(locatorItems[1]);

            case XPATH:
                return By.xpath(locatorItems[1]);

            case TAG:
                return By.tagName(locatorItems[1]);

            case TEXT:
                return By.linkText(locatorItems[1]);

            case PART_TEXT:
                return By.partialLinkText(locatorItems[1]);

            case CLASS :
                return By.className(locatorItems[1]);

            default:
                throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);
        }
    }
}

