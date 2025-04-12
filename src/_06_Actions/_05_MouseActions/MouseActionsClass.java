package _06_Actions._05_MouseActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;


public class MouseActionsClass extends BaseDriver {

    Actions actions = new Actions(driver);

    /**
     * Mouse Actions: Hover the mouse over an element
     */
    @Test
    public void hoverOverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement elementToHover = driver.findElement(By.xpath("(//div[@class='figure'])[1]/img"));
        actions.moveToElement(elementToHover).perform();  // Fareyi element üzerine getir

//      Alternative: hover the mouse over a specific point of the element
//      actions.moveToElement(elementToHover, 50, 50).perform();

        // waitAndClose();
    }

    /**
     * Mouse Actions: Double Click
     */
    @Test
    public void doubleClickTest() {
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();

//        Alternative: To double-click, move on the element first and double-click
//        actions.moveToElement(doubleClickButton).doubleClick().perform();

        // Verify the feedback message (Was the message shown as a result of a double click?)
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        String expectedMessage = "You have done a double click";
        Assert.assertEquals(message.getText(), expectedMessage);

        // waitAndClose();
    }

    /**
     * Mouse Actions: Interaction with Right Click and Alert
     */
    @Test
    public void rightClickTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement elementToRightClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementToRightClick).perform();

        // Handle the alert window that opens
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert content: " + alert.getText());
        alert.accept();

        // waitAndClose();
    }

    /**
     * Mouse Actions: Click
     */
    @Test
    public void clickTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement elementToClick = driver.findElement(By.xpath("//button[text()='Add Element']"));
        actions.click(elementToClick).perform();

//        Alternative: Click action with actions.moveToElement()
//        actions.moveToElement(elementToClick).click().perform();

        // waitAndClose();
    }

    /**
     * Mouse Actions: Click and Hold, Release
     */
    @Test
    public void clickAndHoldReleaseTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement elementToClickAndHold = driver.findElement(By.id("column-a"));
        WebElement elementToDrop = driver.findElement(By.id("column-b"));

        // Click and hold the element and drop it on the target
        actions.clickAndHold(elementToClickAndHold).moveToElement(elementToDrop).release().perform();

//        Alternative: Drag and drop to a specific pixel distance (dragAndDropBy)
//        actions.clickAndHold(elementToClickAndHold).moveByOffset(150, 0).release().perform();

        // waitAndClose();
    }

    /**
     * Mouse Actions: Drag and Drop
     */
    @Test
    public void dragAndDropTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement sourceElement = driver.findElement(By.id("column-a"));
        WebElement targetElement = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(sourceElement, targetElement).perform();  // Drag the source element to the target

        waitAndClose();
    }
}
