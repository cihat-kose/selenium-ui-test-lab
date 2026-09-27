package _07_Alerts._02_Guru99Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class Guru99AlertTest extends BaseDriver {

    /**
     * _05_ExplicitWaitDynamicLoading: Alert Window Management with Simple Right-Click and Double-Click Operations
     */
    @Test
    public void handleAlerts() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();

        WebElement copyOption = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copyOption.click();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Right-click alert: " + alertMessage);
        Assert.assertEquals("clicked: copy", alertMessage);
        driver.switchTo().alert().accept();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickButton).perform();

        String doubleClickAlertMessage = driver.switchTo().alert().getText();
        System.out.println("Double-click alert: " + doubleClickAlertMessage);
        Assert.assertEquals("You double clicked me.. Thank You..", doubleClickAlertMessage);

        driver.switchTo().alert().accept();

        waitAndClose();
    }
}
