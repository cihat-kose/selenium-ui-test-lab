package _11_Windows._02_NewWindowDemoQA;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;
import java.util.Set;

public class NewWindowTest extends BaseDriver {

    /**
     * Example: Handle a new browser window and read content
     */
    @Test
    public void newWindowTest() {
        driver.get("https://demoqa.com/browser-windows");

        List<WebElement> consent = driver.findElements(By.xpath("//p[@class='fc-button-label']"));
        if (!consent.isEmpty()) {
            consent.get(0).click();
        }

        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.id("windowButton")).click();

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text in new window: " + heading.getText());

        waitAndClose();
    }
}
