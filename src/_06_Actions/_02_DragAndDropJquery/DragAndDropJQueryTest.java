package _06_Actions._02_DragAndDropJquery;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class DragAndDropJQueryTest extends BaseDriver {

    @Test
    public void dragAndDropWithBuildPerformTest() {
        Actions actions = new Actions(driver);

        // Step 1: Open the test site
        driver.get("https://jqueryui.com/droppable/");

        // Step 2: Switch to iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        // Step 3: Locate source and target elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Step 4: Perform drag and drop using build().perform()
        actions.clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .build()
                .perform();

        // Step 5: Verify the drop result
        String actualText = target.getText();
        String expectedText = "Dropped!";
        assert actualText.equals(expectedText) : "Drag and drop failed!";

        waitAndClose();
    }
}
