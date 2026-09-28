package _10_Scroll._03_YouTubeSearchAndScroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class YouTubeSearchAndScrollTest extends BaseDriver {

    @Test
    public void searchAndPrint80thVideoTitle() {
        driver.get("https://www.youtube.com/");

        By rejectAllButton = By.cssSelector(
                "button[aria-label='Çerezlerin ve diğer verilerin açıklanan amaçlar doğrultusunda kullanılmasını reddet']");
        List<WebElement> rejectAll = driver.findElements(rejectAllButton);
        if (!rejectAll.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(rejectAllButton)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(rejectAllButton));
        }

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='search_query']")));
        searchBox.click();
        searchBox.sendKeys("Selenium");

        Actions actions = new Actions(driver);

        Action action = actions.moveToElement(searchBox).click().keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        action.perform();

        List<WebElement> videos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer"));

        // Load more results in batches until the 80th video is available.
        while (videos.size() < 80) {
            javascriptExecutor.executeScript("window.scrollBy(0,3000)");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".style-scope ytd-video-renderer")));
            videos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer"));
        }

        String oldTitle = driver.getTitle();
        videos.get(79).click();

        // Wait for the page title to change
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(oldTitle)));
        System.out.println("The Eightieth Video Title: " + driver.getTitle());

        waitAndClose();
    }
}
