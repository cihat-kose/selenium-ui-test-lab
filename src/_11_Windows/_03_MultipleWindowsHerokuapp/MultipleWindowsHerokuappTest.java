package _11_Windows._03_MultipleWindowsHerokuapp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.Set;

public class MultipleWindowsHerokuappTest extends BaseDriver {

    /**
     * Example: Switching between multiple windows on Herokuapp
     */
    @Test
    public void switchBetweenWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Print text from new window
        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println("Text in new window: " + heading.getText());

        // Switch back to original window and print title
        driver.switchTo().window(originalWindow);
        System.out.println("Title of original window: " + driver.getTitle());

        waitAndClose();
    }
}
