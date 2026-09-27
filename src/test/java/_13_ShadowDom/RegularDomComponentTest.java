package _13_ShadowDom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchShadowRootException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/** Shows that a custom-looking HTML component can use regular DOM instead of Shadow DOM. */
public class RegularDomComponentTest extends BaseDriver {

    @Test
    public void useRegularDomForAComponentWithoutShadowRoot() {
        driver.get(Objects.requireNonNull(getClass().getResource("/non-native-component.html"))
                .toExternalForm());

        WebElement component = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("custom-input")));
        assertThrows(NoSuchShadowRootException.class, component::getShadowRoot);

        WebElement username = component.findElement(By.id("username"));
        wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys("student");
        assertEquals("student", username.getAttribute("value"));
        waitAndClose();
    }
}
