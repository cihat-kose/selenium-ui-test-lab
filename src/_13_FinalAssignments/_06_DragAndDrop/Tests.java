package _13_FinalAssignments._06_DragAndDrop;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class Tests extends BaseDriver {

//    Ödev 1 : http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
//    buradaki ülke ve şehirleri findElements ile topluca bularak
//    bir döngü ile bütün şehirleri doğru ülkere dağıtınız.

    @Test
    public void Test1() {
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
    }

//    Ödev 2 : http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
//    buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.

    @Test
    public void Test2() {
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
    }

    //    Challenge sorusu
//    Ödev 3: http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
//    buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
    @Test
    public void Test3() {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        List<WebElement> cities = driver.findElements(By.xpath("//li[starts-with(@id,'node')]"));
        List<WebElement> countryBoxes = driver.findElements(By.xpath("//ul[starts-with (@id,'box')]"));

        for (WebElement city : cities) {
            for (WebElement country : countryBoxes) {
                try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                } catch (NoAlertPresentException e) {

                }
                if (city.getAttribute("groupid").equals(country.getAttribute("id"))) {
                    Actions actions = new Actions(driver);
                    Action action = actions.clickAndHold(city).build();
                    action.perform();
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[starts-with (@id,'box')]")));
                    action = actions.moveToElement(country).release().build();
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[starts-with (@id,'box')]")));
                    action.perform();
                }
            }
        }
        waitAndClose();
    }
}
