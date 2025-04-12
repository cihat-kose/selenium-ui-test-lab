package _13_FinalAssignments._04_BasicCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;

public class BasicCalculatorTest extends BaseDriver {

    /**
     * Task: Basic Calculator Randomized Operations
     */
    @Test
    public void testBasicCalculatorOperations() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        Actions actions = new Actions(driver);

        WebElement integersOnlyRadioInput = driver.findElement(By.id("integerSelect"));

        for (int i = 0; i < 5; i++) {

            int randomNumber1 = (int) (Math.random() * 100);
            int randomNumber2 = (int) (Math.random() * 99) + 1;

            WebElement firstNumber = driver.findElement(By.id("number1Field"));

            if (i == 0) {
                firstNumber.sendKeys(String.valueOf(randomNumber1));
                Action action = actions.moveToElement(firstNumber).click().keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Integer.toString(randomNumber2)).build();
                action.perform();
            } else {
                Action action = actions.moveToElement(firstNumber).click().keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).sendKeys(Integer.toString(randomNumber1)).keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Integer.toString(randomNumber2)).build();
                action.perform();
            }

            for (int j = 0; j < 5; j++) {

                WebElement operationMenu = driver.findElement(By.id("selectOperationDropdown"));

                Select operationSelect = new Select(operationMenu);
                operationSelect.selectByIndex(j);

                wait.until(ExpectedConditions.elementToBeClickable(By.id("calculateButton")));

                WebElement calculateButton = driver.findElement(By.id("calculateButton"));
                calculateButton.click();

                WebElement calculateAnswer = driver.findElement(By.id("numberAnswerField"));

                switch (j) {
                    case 0:
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 + randomNumber2));
                        break;
                    case 1:
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 - randomNumber2));
                        break;
                    case 2:
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf(randomNumber1 * randomNumber2));
                        break;
                    case 3:
                        integersOnlyRadioInput.click();
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), String.valueOf((randomNumber1 / randomNumber2)));
                        break;
                    case 4:
                        Assert.assertEquals(calculateAnswer.getAttribute("value"), "" + randomNumber1 + randomNumber2);
                        break;
                }
                WebElement clearButton = driver.findElement(By.id("clearButton"));
                clearButton.click();
            }
        }
        waitAndClose();
    }
}
