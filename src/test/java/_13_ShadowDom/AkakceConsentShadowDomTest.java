package _13_ShadowDom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import static org.junit.Assert.assertTrue;

/** Demonstrates getShadowRoot() on a live consent component. */
public class AkakceConsentShadowDomTest extends BaseDriver {

    @Test
    public void acceptConsentInsideShadowRoot() {
        driver.get("https://www.akakce.com/");

        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("efilli-layout-tuttur")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement acceptButton = wait.until(d -> {
            WebElement button = shadowRoot.findElement(By.cssSelector("div[data-name='kabul et']"));
            return button.isDisplayed() && button.isEnabled() ? button : null;
        });

        acceptButton.click();
        assertTrue("The consent button should disappear after acceptance.",
                wait.until(ExpectedConditions.invisibilityOf(acceptButton)));
        waitAndClose();
    }
}
