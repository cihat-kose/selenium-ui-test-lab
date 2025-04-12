package _09_IFrames._01_IframeCount;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class IframeCountTest extends BaseDriver {

    @Test
    public void countIframesOnPage() {
        driver.get("https://demoqa.com/frames");

        // Accept cookies if present
        List<WebElement> consent = driver.findElements(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']//p"));
        if (!consent.isEmpty()) consent.get(0).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("iframe")));

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iframes.size());

        waitAndClose();
    }
}
