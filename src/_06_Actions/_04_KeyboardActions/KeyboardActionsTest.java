package _06_Actions._04_KeyboardActions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class KeyboardActionsTest extends BaseDriver {

    Actions actions = new Actions(driver);

    /**
     * Keyboard Actions: Pressing a single key (e.g., SPACE)
     */
    @Test
    public void sendSpaceKeyTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.SPACE);

//        Alternative: Using Actions
//        actions.sendKeys(Keys.SPACE).perform();

//        waitAndClose();
    }

    /**
     * Keyboard Actions: CTRL + A using chord
     */
    @Test
    public void ctrlAWithChordTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.chord(Keys.CONTROL, "a"));

//        Alternative: using keyDown and keyUp
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

//        waitAndClose();
    }

    /**
     * Keyboard Actions: SHIFT + T to type uppercase T
     */
    @Test
    public void shiftTCombinationTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.chord(Keys.SHIFT, "t"));

//        Alternative: Simply sending uppercase T
//        body.sendKeys("T");

//        waitAndClose();
    }

    /**
     * Keyboard Actions: CTRL + A and then DELETE using chained actions
     */
    @Test
    public void ctrlAThenDeleteChainTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement body = driver.findElement(By.tagName("body"));

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE).perform();

//        Alternative using chord:
//        body.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        waitAndClose();
    }
}
