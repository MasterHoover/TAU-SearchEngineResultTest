package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class SearchEngine extends WebPage
{
    private final By searchBox;
    private final By searchButton;
    private final By searchResults;

    public SearchEngine(WebDriver driver, String url, By searchBox, By searchButton, By searchResults)
    {
        super(driver, url);
        this.searchBox = searchBox;
        this.searchButton = searchButton;
        this.searchResults = searchResults;
    }

    public void search(String phrase)
    {
        WebElement searchBox = getWait().until(ExpectedConditions.visibilityOfElementLocated(this.searchBox));
        searchBox.sendKeys(phrase);
        WebElement searchButton = getWait().until(ExpectedConditions.visibilityOfElementLocated(this.searchButton));
        searchButton.click();
        getWait().until(ExpectedConditions.titleContains(phrase));
    }

    public List<WebElement> fetchResults()
    {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        return getDriver().findElements(searchResults);
    }
}
