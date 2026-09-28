package _10_Scroll._03_YouTubeSearchAndScroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import utility.BaseDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

/** Searches YouTube, loads results with scrolling, and opens the 80th result when available. */
public class YouTubeSearchAndScrollTest extends BaseDriver {

    @Test
    public void searchAndPrint80thVideoTitle() {
        useExplicitWaitsOnly();
        driver.get("https://www.youtube.com/");

        List<WebElement> rejectAll = driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("search_query")));
        searchBox.click();
        searchBox.sendKeys("Selenium");

        Actions actions = new Actions(driver);

        Action action = actions.moveToElement(searchBox).click().sendKeys(Keys.ENTER).build();
        action.perform();

        By videoCards = By.cssSelector("ytd-video-renderer");
        List<WebElement> videos = wait.until(d -> {
            List<WebElement> results = d.findElements(videoCards);
            return results.isEmpty() ? null : results;
        });

        int maximumScrollAttempts = 12;
        int scrollAttempts = 0;
        while (videos.size() < 80 && scrollAttempts < maximumScrollAttempts) {
            int currentCount = videos.size();
            javascriptExecutor.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");

            try {
                new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.numberOfElementsToBeMoreThan(videoCards, currentCount));
            } catch (TimeoutException noAdditionalResultsLoaded) {
                break;
            }
            videos = driver.findElements(videoCards);
            scrollAttempts++;
        }

        assertTrue("Expected 80 video results, but only loaded " + videos.size() + ".", videos.size() >= 80);
        WebElement eightiethVideoTitle = videos.get(79).findElement(By.cssSelector("a#video-title"));
        String expectedVideoTitle = eightiethVideoTitle.getText().trim();
        assertTrue("The 80th video should have a visible title.", !expectedVideoTitle.isEmpty());
        eightiethVideoTitle.click();

        wait.until(ExpectedConditions.urlContains("watch"));
        assertTrue("Opening the 80th result should navigate to a video page.",
                driver.getCurrentUrl().contains("watch"));
        System.out.println("The Eightieth Video Title: " + expectedVideoTitle);

        waitAndClose();
    }
}
