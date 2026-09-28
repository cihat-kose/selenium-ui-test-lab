package _06_Actions._04_KeyboardActions;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertEquals;

/** Demonstrates single keys, chords, and chained keyboard actions on a local practice page. */
public class KeyboardActionsTest extends BaseDriver {

    private Actions actions;

    @Before
    public void createActions() {
        useExplicitWaitsOnly();
        actions = new Actions(driver);
    }

    /**
     * Presses SPACE and verifies that the page received that key.
     */
    @Test
    public void sendSpaceKeyTest() {
        openFixture("keyboard-actions.html");
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("keyboard-input")));
        input.sendKeys(Keys.SPACE);

        assertEquals("SPACE", driver.findElement(By.id("key-log")).getText());
        waitAndClose();
    }

    /**
     * Sends CTRL+A as one chord and verifies the key combination received by the page.
     */
    @Test
    public void ctrlAWithChordTest() {
        openFixture("keyboard-actions.html");
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("keyboard-input")));
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        assertEquals("CTRL+A", driver.findElement(By.id("key-log")).getText());
        waitAndClose();
    }

    /**
     * Holds SHIFT while sending T and checks the reported combination.
     */
    @Test
    public void shiftTCombinationTest() {
        openFixture("keyboard-actions.html");
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("keyboard-input")));
        input.sendKeys(Keys.chord(Keys.SHIFT, "t"));

        assertEquals("SHIFT+T", driver.findElement(By.id("key-log")).getText());
        waitAndClose();
    }

    /**
     * Chains CTRL+A and DELETE, then checks both the key sequence and input value.
     */
    @Test
    public void ctrlAThenDeleteChainTest() {
        openFixture("keyboard-actions.html");
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("keyboard-input")));

        actions.click(input).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE).perform();

        assertEquals("", input.getAttribute("value"));
        assertEquals("CTRL+A, DELETE", driver.findElement(By.id("key-log")).getText());
        waitAndClose();
    }
}
