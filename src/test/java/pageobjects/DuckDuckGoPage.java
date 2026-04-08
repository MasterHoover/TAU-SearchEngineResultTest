package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuckDuckGoPage extends SearchEngine
{
    public static final String DuckDuckGoPageURL = "https://www.duckduckgo.com";
    public static final By searchBoxLocator = By.id("searchbox_input");
    public static final By searchButtonLocator = By.cssSelector("button[data-mode='search']");
    public static final By searchResultsLocator = By.cssSelector("ol.react-results--main article div[data-result='snippet']");

    public DuckDuckGoPage(WebDriver driver) { super(driver, DuckDuckGoPageURL, searchBoxLocator, searchButtonLocator, searchResultsLocator);}
}
