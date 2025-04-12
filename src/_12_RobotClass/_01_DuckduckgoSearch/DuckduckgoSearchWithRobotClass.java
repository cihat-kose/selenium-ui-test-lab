package _12_RobotClass._01_DuckduckgoSearch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DuckduckgoSearchWithRobotClass extends BaseDriver {

    @Test
    public void searchDuckduckgo() throws AWTException {
        driver.get("https://duckduckgo.com");

        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
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

        // Wait until search results load (first <h3> is visible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h3")));

        // Move mouse to top-right corner of screen (adjusted for resolution)
        robot.mouseMove(screenWidth - 10, 50);
        MyFunction.wait(2);

        // Perform left click
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        MyFunction.wait(2);

        // Move mouse to bottom-left corner (resolution-sensitive)
        robot.mouseMove(10, screenHeight - 50);
        MyFunction.wait(2);

        // Perform right click
        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);

        waitAndClose();
    }
}
