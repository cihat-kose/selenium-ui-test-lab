package _13_FinalAssignments._06_DragAndDrop._02_StudentBoxDistribution;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class StudentBoxDistributionTest extends BaseDriver {

    /**
     * Task: Distribute students into all boxes using drag and drop.
     */
    @Test
    public void distributeStudentsIntoBoxes() {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        List<WebElement> students = driver.findElements(By.xpath("//li[starts-with(@id,'node')]"));
        List<WebElement> boxes = driver.findElements(By.xpath("//ul[starts-with (@id,'box')]"));

        for (WebElement student : students) {
            for (WebElement box : boxes) {
                Actions actions = new Actions(driver);
                Action action = actions.clickAndHold(student).build();
                action.perform();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[starts-with (@id,'box')]")));
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[starts-with(@id,'node')]")));
                action = actions.moveToElement(box).release().build();
                action.perform();
            }
        }

        waitAndClose();
    }
}
