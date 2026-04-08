**Test summary:**<br/>
Web page tested: DuckDuckGo.com<br/>
This test searches for "giant panda" in the DuckDuckGo search engine and test if the initial results (before clicking "More results" button) each contain the keywords "giant", "panda", or both.

**Tools**<br/>
Language: Java<br/>
Framework: Selenium + JUnit<br/>
Browser: Chrome

**Credits:**<br/>
School: Test Automation University (TAU)<br/>
Course: Web Element Locator Strategies<br/>
Chapter: Chapter 8 - "Using Locators for testing

**STEPS:**<br/>
1. Find the Search bar
2. Write the keywords into the search bar
3. Locate the "search"/"submit" button and click it
4. Locate the list of results
5. Analyze the texts of the results and confirm if they contain either "giant", "panda" or both

**My Locators:**<br/>
Search bar<br/>
- `By.id("searchbox_input")`<br/>
Search button<br/>
- `By.cssSelector("button[data-mode='search']")`<br/>
Search result text<br/>
- `By.cssSelector("ol.react-results--main article div[data-result='snippet']")`

**Useful Functions**<br/>
- `new WebDriver()` : Initialize the WebDriver. Used to open Google Chrome and get the Elements within the pages
- `new WebDriverWait(WebDriver, Duration)` : Initialize the Wait. Used to wait until some Elements are displayed before fetching Elements.
- `WebDriver.get(String url)` : Opens chrome and the web page
- `WebDriver.sendKeys(String text)` : Will write the text
- `WebElement.click()` : Click the element (must be clickable)
- `WebDriver.findElement(locator)` : finds one WebElement
- `WebDriver.findElements(locator)` : finds multiple Elements (returns a List<WebElement>)
- `WebElement.getText()` : Get the text of a WebElement
- `String.matches(regex)` : returns true if matches, false otherwise
- `wait.until(ExpectedConditions)` : Wait until the expected conditions are met. Return the specific WebElement when it's ready. The wait duration is set when initializing the WebDriverWait variable.
