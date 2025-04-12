package _09_IFrames._03_TextArea;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class IframeTextAreaEditTest extends BaseDriver {

    @Test
    public void editTextareaInIframe() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea");

        List<WebElement> acceptCookies = driver.findElements(By.id("accept-choices"));
        if (!acceptCookies.isEmpty()) acceptCookies.get(0).click();

        // Switch to iframe using WebElement (recommended way)
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        // 🔁 Alternative ways to switch to iframe:
//        driver.switchTo().frame("iframeResult");  // If the iframe has an ID or name
//        driver.switchTo().frame(0);               // If it's the only iframe on the page
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));

        WebElement textArea = driver.findElement(By.xpath("//textarea"));
        textArea.clear();
        textArea.sendKeys("This text was changed with Selenium!");

        driver.switchTo().parentFrame();  // ⬅ One level up
        // driver.switchTo().defaultContent();  // ⬅ All the way back to main page

        waitAndClose();
    }
}
