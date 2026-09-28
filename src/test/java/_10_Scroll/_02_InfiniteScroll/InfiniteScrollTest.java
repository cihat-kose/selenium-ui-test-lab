package _10_Scroll._02_InfiniteScroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class InfiniteScrollTest extends BaseDriver {

    /**
     * Task: Load and Print 10 Paragraphs with Infinite Scroll
     */
    @Test
    public void loadAndPrintTenParagraphs() {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        By paragraphsLocator = By.cssSelector("div.jscroll-added");
        List<String> paragraphs = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            // Reaching the bottom triggers the page to append its next paragraph.
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            int expectedCount = i;
            wait.until(d -> d.findElements(paragraphsLocator).size() >= expectedCount);

            MyFunction.wait(1); // Optional: Wait for a second to ensure the paragraph is fully loaded

            WebElement paragraph = driver.findElements(paragraphsLocator).get(i - 1);
            String text = paragraph.getText().trim();
            assertFalse("Loaded paragraph " + i + " should not be empty.", text.isEmpty());
            paragraphs.add(text);

            System.out.println(i + ". Paragraph: " + text);
        }

        assertEquals("The page should load exactly ten paragraphs.", 10, paragraphs.size());

        waitAndClose();
    }
}
