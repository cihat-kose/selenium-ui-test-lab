package _11_Windows._01_NewTabLocalFixture;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.nio.file.Paths;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NewTabWindowTest extends BaseDriver {

    /**
     * Task: Open a New Tab and Read Text
     */
    @Test
    public void newTabWindowTest() {
        driver.get(Paths.get("src/test/resources/new-tab.html").toAbsolutePath().toUri().toString());

        String mainTabID = driver.getWindowHandle();
        driver.findElement(By.id("open-tab")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowIDs = driver.getWindowHandles();
        String newTabID = windowIDs.stream()
                .filter(id -> !id.equals(mainTabID))
                .findFirst()
                .orElseThrow(() -> new AssertionError("The new tab was not opened."));
        driver.switchTo().window(newTabID);

        wait.until(ExpectedConditions.titleIs("New tab practice target"));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sample-heading")));
        String sampleText = heading.getText();
        assertEquals("This is a sample page", sampleText);

        driver.close();
        driver.switchTo().window(mainTabID);
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        assertEquals(1, driver.getWindowHandles().size());

        waitAndClose();
    }
}
