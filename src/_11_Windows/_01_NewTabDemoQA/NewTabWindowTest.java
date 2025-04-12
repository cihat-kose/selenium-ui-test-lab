package _11_Windows._01_NewTabDemoQA;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;
import java.util.Set;

public class NewTabWindowTest extends BaseDriver {

    /**
     * Task: Open a New Tab and Read Text
     */
    @Test
    public void newTabWindowTest() {
        driver.get("https://demoqa.com/browser-windows");

        List<WebElement> consent = driver.findElements(By.xpath("//p[@class='fc-button-label']"));
        if (!consent.isEmpty()) {
            consent.get(0).click();
        }

        String mainTabID = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        // Get all window handles and switch to the new one
        Set<String> windowIDs = driver.getWindowHandles();
        for (String id : windowIDs) {
            if (!id.equals(mainTabID)) {
                driver.switchTo().window(id);
                break;
            }
        }

        WebElement sampleText = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text in new tab: " + sampleText.getText());

        waitAndClose();
    }
}
