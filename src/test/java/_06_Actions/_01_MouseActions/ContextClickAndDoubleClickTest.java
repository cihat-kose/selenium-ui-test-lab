package _06_Actions._01_MouseActions;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class ContextClickAndDoubleClickTest extends BaseDriver {

    @Test
    public void verifyContextClickAndDoubleClickAlerts() {
        Actions actions = new Actions(driver);

        // Open the demo page for custom context-menu and double-click events.
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));

        // Locate the button before interacting with the context menu.
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

        // Open the custom context menu with a right-click.
        actions.moveToElement(rightClickButton)
                .contextClick(rightClickButton)
                .perform();

        // Choose Copy and verify the page's alert response.
        WebElement copyOption = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copyOption.click();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Right-click alert: " + alertMessage);
        Assert.assertEquals("clicked: copy", alertMessage);
        driver.switchTo().alert().accept();

        // Verify the separate alert triggered by a double-click.
        actions.moveToElement(doubleClickButton)
                .doubleClick(doubleClickButton)
                .perform();

        String doubleClickAlert = driver.switchTo().alert().getText();
        String expectedAlert = "You double clicked me.. Thank You..";
        Assert.assertEquals("Unexpected alert message after double click", expectedAlert, doubleClickAlert);

        driver.switchTo().alert().accept();

        // Intentional observation pause; see the README wait guidance.
        waitAndClose();
    }
}
