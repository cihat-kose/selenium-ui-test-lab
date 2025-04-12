package _06_Actions._01_ContextClickAndDoubleClickTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class ContextClickAndDoubleClickTest extends BaseDriver {

    @Test
    public void chainOfActionsTest() {
        Actions actions = new Actions(driver);

        // 1. Step: Go to the test
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));

        // 3. Step: Find the element to double-click
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

        // 4. Step: Perform right-click action
        actions.moveToElement(rightClickButton)
                .contextClick(rightClickButton)
                .perform();

        // 5. Step: Click on "Copy" option from context menu
        WebElement copyOption = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copyOption.click();

        // 6. Step: Verify and close the alert after right-click
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Right-click alert: " + alertMessage);
        driver.switchTo().alert().accept();

        // 7. Step: Perform double-click action
        actions.moveToElement(doubleClickButton)
                .doubleClick(doubleClickButton)
                .perform();

        // 8. Step: Verify the alert after double-click
        String doubleClickAlert = driver.switchTo().alert().getText();
        String expectedAlert = "You double clicked me.. Thank You..";
        assert doubleClickAlert.equals(expectedAlert) : "Unexpected alert message after double click";

        // 9. Step: Close the alert after double-click
        driver.switchTo().alert().accept();

        // 10. Step: Close the browser
        waitAndClose();
    }
}
