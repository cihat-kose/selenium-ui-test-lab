package _06_Actions._06_DragAndDropPractice._02_StudentBoxDistribution;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentBoxDistributionTest extends BaseDriver {

    /**
     * Task: Distribute students into all boxes using drag and drop.
     */
    @Test
    public void distributeStudentsIntoBoxes() {
        useExplicitWaitsOnly();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        By studentLocator = By.xpath("//li[starts-with(@id,'node')]");
        By boxLocator = By.xpath("//ul[starts-with(@id,'box')]");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(studentLocator));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(boxLocator));
        List<WebElement> students = driver.findElements(studentLocator);
        List<WebElement> boxes = driver.findElements(boxLocator);
        assertTrue("The page should have at least one student and one target box.",
                !students.isEmpty() && !boxes.isEmpty());
        assertTrue("There should be at least one student for every target box.", students.size() >= boxes.size());

        for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
            WebElement student = students.get(studentIndex);
            int targetBoxIndex = studentIndex % boxes.size();
            String targetBoxId = boxes.get(targetBoxIndex).getAttribute("id");
            int expectedCountInTarget = studentIndex / boxes.size() + 1;

            new Actions(driver).clickAndHold(student)
                    .moveToElement(driver.findElement(By.id(targetBoxId)))
                    .release()
                    .perform();

            wait.until(d -> d.findElement(By.id(targetBoxId))
                    .findElements(By.xpath("./li[starts-with(@id,'node')]"))
                    .size() >= expectedCountInTarget);
        }

        for (int boxIndex = 0; boxIndex < boxes.size(); boxIndex++) {
            String boxId = boxes.get(boxIndex).getAttribute("id");
            int expectedCount = students.size() / boxes.size()
                    + (boxIndex < students.size() % boxes.size() ? 1 : 0);
            assertEquals("Unexpected number of students in " + boxId + ".", expectedCount,
                    driver.findElement(By.id(boxId))
                            .findElements(By.xpath("./li[starts-with(@id,'node')]"))
                            .size());
        }

        for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
            String studentId = students.get(studentIndex).getAttribute("id");
            String expectedBoxId = boxes.get(studentIndex % boxes.size()).getAttribute("id");
            assertEquals("Student " + studentId + " should be in " + expectedBoxId + ".", 1,
                    driver.findElement(By.id(expectedBoxId)).findElements(By.id(studentId)).size());
        }

        waitAndClose();
    }
}
