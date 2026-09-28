package _06_Actions._06_DragAndDropPractice._01_CountryCityQuiz;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountryCityQuizTest extends BaseDriver {

    /**
     * Task: Match each city with the correct country using drag and drop.
     * URL: http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
     */

    @Test
    public void matchCitiesToCountries() {
        useExplicitWaitsOnly();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        By cityLocator = By.xpath("//div[starts-with(@id,'a') and @class='dragDropSmallBox']");
        By countryDropAreaLocator = By.xpath("//div[starts-with(@id,'q') and @class='dragDropSmallBox']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cityLocator));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryDropAreaLocator));
        List<WebElement> cities = driver.findElements(cityLocator);
        List<WebElement> countryDropAreas = driver.findElements(countryDropAreaLocator);
        assertEquals("Every city should have one country drop area.", cities.size(), countryDropAreas.size());

        for (WebElement city : cities) {
            String cityId = city.getAttribute("id");
            String countryDropAreaId = "q" + cityId.substring(1);
            WebElement countryDropArea = driver.findElement(By.id(countryDropAreaId));

            new Actions(driver).clickAndHold(city).moveToElement(countryDropArea).release().perform();
            wait.until(d -> d.findElement(By.id(countryDropAreaId)).findElements(By.id(cityId)).size() == 1);
        }

        for (WebElement city : cities) {
            String expectedDropAreaId = "q" + city.getAttribute("id").substring(1);
            assertTrue("City " + city.getText() + " should be in " + expectedDropAreaId + ".",
                    driver.findElement(By.id(expectedDropAreaId))
                            .findElements(By.id(city.getAttribute("id"))).size() == 1);
        }

        waitAndClose();
    }
}
