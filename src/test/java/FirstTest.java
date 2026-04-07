import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    final long WAIT_TIME_IN_SECONDS = 15;

    @BeforeEach
    public void initWebDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    @Test
    public void openGoogleTest() {

        // Load the page
        driver.get("https://duckduckgo.com");

        // Enter the search phrase
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox_input")));
        WebElement searchInput = driver.findElement(By.id("searchbox_input"));
        searchInput.sendKeys("giant panda");

        // Click search button

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-mode='search']"))); //driver.findElement(By.cssSelector("button[data-mode='search']"));
        searchButton.click();

        // Wait for results to appear
        wait.until(ExpectedConditions.titleContains("giant panda"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.kY2IgmnCmOGjharHErah")));

        //Fetch all the results
        List<WebElement> results = driver.findElements(By.cssSelector("span.kY2IgmnCmOGjharHErah"));

        // Make sure each result contains the word "panda
        int index = 1;
        System.out.println("LOOKING AT " + results.size() + " RESULTS:");
        for (WebElement result : results) {
            boolean pass = result.getText().matches("(?i).*panda.*");
            String log = "Result " + index++;

            log += pass ? " Passed." : " Failed.";
            System.out.println(log);

            assert (pass);
        }
    }

    @AfterEach
    public void quitWebDriver() { driver.quit(); }
}
