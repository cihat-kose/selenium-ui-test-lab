package _13_FinalAssignments._06_DragAndDrop._01_CountryCityQuiz;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class CountryCityQuizTest extends BaseDriver {

    /**
     * Task: Match each city with the correct country using drag and drop.
     * URL: http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
     */

    @Test
    public void matchCitiesToCountries() {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        List<WebElement> cities = driver.findElements(By.xpath("//div[starts-with(@id,'a') and @class='dragDropSmallBox']"));
        List<WebElement> blanks = driver.findElements(By.xpath("//div[starts-with(@id,'q') and @class='dragDropSmallBox']"));

        for (WebElement city : cities) {
            Actions actions = new Actions(driver);
            Action action = actions.clickAndHold(city).build();
            action.perform();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[starts-with(@id,'q') and @class='dragDropSmallBox']")));
            for (WebElement blank : blanks) {
                if (city.getAttribute("id").substring(1).equals(blank.getAttribute("id").substring(1))) {
                    action = actions.moveToElement(blank).release().build();
                    action.perform();
                }
            }
        }

        waitAndClose(); // Optionally close the browser after test
    }
}
