package _06_Actions._06_DragAndDropPractice._03_CityCountryChallenge;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CityCountryChallengeTest extends BaseDriver {

    /**
     * Task: Match cities with their correct countries using drag and drop.
     */
    @Test
    public void matchCitiesToCountries() {
        useExplicitWaitsOnly();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        By cityLocator = By.xpath("//li[starts-with(@id,'node')]");
        By countryBoxLocator = By.xpath("//ul[starts-with(@id,'box')]");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cityLocator));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryBoxLocator));
        List<WebElement> cities = driver.findElements(cityLocator);
        List<WebElement> countryBoxes = driver.findElements(countryBoxLocator);
        assertTrue("The quiz should contain cities and country boxes.",
                !cities.isEmpty() && !countryBoxes.isEmpty());

        for (WebElement city : cities) {
            String cityId = city.getAttribute("id");
            String countryBoxId = city.getAttribute("groupid");
            WebElement countryBox = driver.findElement(By.id(countryBoxId));

            new Actions(driver).clickAndHold(city).moveToElement(countryBox).release().perform();
            acceptAlertIfPresent();
            wait.until(d -> d.findElement(By.id(countryBoxId)).findElements(By.id(cityId)).size() == 1);
        }

        for (WebElement city : cities) {
            String expectedCountryBoxId = city.getAttribute("groupid");
            assertTrue("City " + city.getText() + " should be in " + expectedCountryBoxId + ".",
                    driver.findElement(By.id(expectedCountryBoxId))
                            .findElements(By.id(city.getAttribute("id"))).size() == 1);
        }

        waitAndClose();
    }

    /** This quiz may show a native JavaScript alert after a correct drop. */
    private void acceptAlertIfPresent() {
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofMillis(500))
                    .until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (TimeoutException exception) {
            // This particular drop did not produce an alert, so continue with the DOM assertion.
        }
    }
}
