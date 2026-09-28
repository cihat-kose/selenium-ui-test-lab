package _07_Alerts._02_Guru99Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class Guru99AlertTest extends BaseDriver {

    @Test
    public void validateContextMenuAndDoubleClickAlerts() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement contextMenuButton = driver.findElement(By.cssSelector(".context-menu-one"));
        new Actions(driver).contextClick(contextMenuButton).perform();

        driver.findElement(By.cssSelector(".context-menu-icon-copy")).click();
        Alert contextMenuAlert = driver.switchTo().alert();
        Assert.assertEquals("clicked: copy", contextMenuAlert.getText());
        contextMenuAlert.accept();

        WebElement doubleClickButton = driver.findElement(
                By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
        new Actions(driver).doubleClick(doubleClickButton).perform();

        Alert doubleClickAlert = driver.switchTo().alert();
        Assert.assertEquals("You double clicked me.. Thank You..", doubleClickAlert.getText());
        doubleClickAlert.accept();

        // Intentional observation pause for this lesson; see the README wait guidance.
        waitAndClose();
    }
}
