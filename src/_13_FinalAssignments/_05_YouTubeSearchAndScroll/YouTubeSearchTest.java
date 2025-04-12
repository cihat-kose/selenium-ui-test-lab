package _13_FinalAssignments._05_YouTubeSearchAndScroll;

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

public class YouTubeSearchTest extends BaseDriver {

    @Test
    public void searchAndPrint80thVideoTitle() {
        driver.get("https://www.youtube.com/");

        List<WebElement> rejectAll = driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        ((JavascriptExecutor) driver).executeScript("location.reload();");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBox.sendKeys("Selenium");

        Actions actions = new Actions(driver);

        Action action = actions.moveToElement(searchBox).click().keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        action.perform();

        List<WebElement> videos = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer"));

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
