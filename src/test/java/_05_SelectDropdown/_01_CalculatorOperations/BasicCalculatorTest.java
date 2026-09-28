package _05_SelectDropdown._01_CalculatorOperations;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;

public class BasicCalculatorTest extends BaseDriver {

    /**
     * Runs the same five calculator operations for several reproducible input pairs.
     */
    @Test
    public void testBasicCalculatorOperations() {
        useExplicitWaitsOnly();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        Actions actions = new Actions(driver);

        WebElement integersOnlyRadioInput = driver.findElement(By.id("integerSelect"));

        int[][] inputPairs = {{27, 4}, {42, 7}, {85, 9}, {36, 11}, {91, 13}};
        for (int i = 0; i < inputPairs.length; i++) {
            int firstNumberValue = inputPairs[i][0];
            int secondNumberValue = inputPairs[i][1];

            WebElement firstNumber = driver.findElement(By.id("number1Field"));
            actions.moveToElement(firstNumber).click()
                    .sendKeys(String.valueOf(firstNumberValue))
                    .sendKeys(Keys.TAB)
                    .sendKeys(String.valueOf(secondNumberValue))
                    .perform();

            for (int j = 0; j < 5; j++) {

                WebElement operationMenu = driver.findElement(By.id("selectOperationDropdown"));

                Select operationSelect = new Select(operationMenu);
                operationSelect.selectByIndex(j);

                String expectedAnswer = switch (j) {
                    case 0 -> String.valueOf(firstNumberValue + secondNumberValue);
                    case 1 -> String.valueOf(firstNumberValue - secondNumberValue);
                    case 2 -> String.valueOf(firstNumberValue * secondNumberValue);
                    case 3 -> String.valueOf(firstNumberValue / secondNumberValue);
                    case 4 -> String.valueOf(firstNumberValue) + secondNumberValue;
                    default -> throw new IllegalStateException("Unexpected calculator operation index: " + j);
                };

                if (j == 3 && !integersOnlyRadioInput.isSelected()) {
                    integersOnlyRadioInput.click();
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.id("calculateButton"))).click();

                String actualAnswer = wait.until(d -> {
                    String value = d.findElement(By.id("numberAnswerField")).getAttribute("value");
                    return expectedAnswer.equals(value) ? value : null;
                });
                Assert.assertEquals("Unexpected answer for operation index " + j + ".",
                        expectedAnswer, actualAnswer);
            }

            // Keep the same pair for all five calculations; clear once before entering the next pair.
            driver.findElement(By.id("clearButton")).click();
            wait.until(d -> d.findElement(By.id("number1Field")).getAttribute("value").isEmpty()
                    && d.findElement(By.id("number2Field")).getAttribute("value").isEmpty());
        }
        waitAndClose();
    }
}
