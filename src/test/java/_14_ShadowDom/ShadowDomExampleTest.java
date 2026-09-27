package _14_ShadowDom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * Finds a button inside a native Shadow DOM and verifies the visible result of clicking it.
 */
public class ShadowDomExampleTest extends BaseDriver {

    @Test
    public void clickButtonInsideOpenShadowRoot() {
        driver.get(Objects.requireNonNull(getClass().getResource("/shadow-dom-example.html")).toExternalForm());

        // Find the custom element that owns the Shadow DOM (the shadow host).
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("consent-panel")));

        // A normal driver.findElement search cannot cross the Shadow DOM boundary.
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.id("accept")).click();

        WebElement result = wait.until(d -> shadowRoot.findElement(By.id("result")));
        assertEquals("Consent accepted", result.getText());
        waitAndClose();
    }
}
