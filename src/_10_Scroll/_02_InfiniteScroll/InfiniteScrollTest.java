package _10_Scroll._02_InfiniteScroll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class InfiniteScrollTest extends BaseDriver {

    /**
     * Task: Load and Print 10 Paragraphs with Infinite Scroll
     */
    @Test
    public void loadAndPrintTenParagraphs() {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        for (int i = 1; i <= 10; i++) {
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            MyFunction.wait(1);

            WebElement paragraph = driver.findElement(By.xpath("(//div[@class='jscroll-added'])[" + i + "]"));

            System.out.println(i + ". Paragraph: " + paragraph.getText());
        }

        waitAndClose();
    }
}
