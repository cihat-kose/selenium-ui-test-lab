package _12_RobotClass._01_DuckDuckGoSearch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Uses Robot to paste a search, submit it, and move the desktop pointer safely. */
public class DuckDuckGoRobotSearchTest extends BaseDriver {

    @Test
    public void searchDuckduckgo() throws AWTException {
        useExplicitWaitsOnly();
        driver.get("https://duckduckgo.com");

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchbox_input")));
        searchBox.click();

        // Initialize Robot instance
        Robot robot = new Robot();

        // Dynamically fetch screen size (for mouse movement compatibility with any screen)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Copy text to clipboard
        String searchTerm = "Selenium Robot Class";
        StringSelection stringSelection = new StringSelection(searchTerm);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Simulate Ctrl + V to paste the text
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to perform the search
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Check the browser reached search results before using the mouse.
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//h3)[1]")));
        assertFalse("The first result should have a title.", firstResult.getText().trim().isEmpty());
        assertTrue("The URL should contain the search term.",
                driver.getCurrentUrl().toLowerCase().contains("selenium"));

        // Move the pointer within the desktop without clicking browser or operating-system controls.
        robot.mouseMove(screenWidth / 2, screenHeight / 2);
        MyFunction.wait(1);

        waitAndClose();
    }
}
