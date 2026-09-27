package _05_Select_ElementInStatus;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

public class SelectDropdownAllMethodsTask extends BaseDriver {

    @Test
    public void testSelectDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // 1. Select by visible text
        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
        System.out.println("Selected by visible text: " + dropdown.getFirstSelectedOption().getText());

        MyFunction.wait(2); /// For visibility only. Use WebDriverWait in real automation.

        // 2. Select by value
        dropdown.selectByValue("1");
        Assert.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());
        System.out.println("Selected by value: " + dropdown.getFirstSelectedOption().getText());

        MyFunction.wait(2); /// For visibility only. Use WebDriverWait in real automation.

        // 3. Select by index
        dropdown.selectByIndex(2); // Option 2
        Assert.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
        System.out.println("Selected by index: " + dropdown.getFirstSelectedOption().getText());

        MyFunction.wait(2); /// For visibility only. Use WebDriverWait in real automation.

        // 4. Get all options
        List<WebElement> options = dropdown.getOptions();
        System.out.println("All available options:");
        for (WebElement option : options) {
            System.out.println("- " + option.getText());
        }

        MyFunction.wait(2); /// For visibility only. Use WebDriverWait in real automation.

        // 5. Get first selected option
        WebElement firstSelected = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelected.getText());
        Assert.assertEquals("Option 2", firstSelected.getText());

        // 6. getAllSelectedOptions() (mostly useful for multi-select dropdowns)
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        System.out.println("Selected options count: " + selectedOptions.size());

        // 7. deselectAll() – only for multi-select dropdowns
        // dropdown.deselectAll(); // Not applicable here (single-select)

        waitAndClose();
    }
}
