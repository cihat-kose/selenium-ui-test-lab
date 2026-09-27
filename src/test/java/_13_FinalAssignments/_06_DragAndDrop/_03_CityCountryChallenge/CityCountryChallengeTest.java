package _13_FinalAssignments._06_DragAndDrop._03_CityCountryChallenge;

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

public class CityCountryChallengeTest extends BaseDriver {

    /**
     * Task: Match cities with their correct countries using drag and drop.
     */
    @Test
    public void matchCitiesToCountries() {
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
