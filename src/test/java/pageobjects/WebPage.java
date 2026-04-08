package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebPage
{
    private final String url;
    private static final long TIMEOUT = 10;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebPage(WebDriver driver, String url)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        this.url = url;
    }

    public void loadPage()
    {
        driver.get(url);
    }

    public WebDriver getDriver() { return driver; }
    public WebDriverWait getWait () { return wait; }
}
