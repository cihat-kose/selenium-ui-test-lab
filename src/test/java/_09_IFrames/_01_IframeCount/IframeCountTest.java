package _09_IFrames._01_IframeCount;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class IframeCountTest extends BaseDriver {

    @Test
    public void countIframesOnPage() {
        useExplicitWaitsOnly();
        driver.get("https://www.selenium.dev/selenium/web/iframes.html");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframe1")));

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iframes.size());
        assertTrue("The Selenium iframe example should contain at least one iframe.", !iframes.isEmpty());

        waitAndClose();
    }
}
