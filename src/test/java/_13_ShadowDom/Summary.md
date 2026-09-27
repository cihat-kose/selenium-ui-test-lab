# 🌳 Shadow DOM: A Separate Area Inside a Web Page

## What is it?

A page component can keep its buttons, text, and other elements in its own separate area. That area is called **Shadow DOM**.

You can still see the button on screen. But a normal `driver.findElement(...)` search from the main page does not reach inside that area.

## Why does it matter in a test?

Imagine an **Accept** button inside such a component. To click it, Selenium must first find the component and access its inner area.

Only two new terms are needed:

- **Shadow host:** the element that owns the separate area.
- **Shadow root:** the place Selenium starts searching inside that area.

## What do we test here?

Open [ShadowDomExampleTest](ShadowDomExampleTest.java).

1. Open our local practice page.
2. Find its `consent-panel` element: this is the host.
3. Call `getShadowRoot()` to access the elements inside.
4. Find and click **Accept** there.
5. Check that the message becomes **Consent accepted**.

The important part is just:

```java
WebElement host = driver.findElement(By.cssSelector("consent-panel"));
SearchContext inside = host.getShadowRoot();
inside.findElement(By.id("accept")).click();
```

**In one sentence:** We enter the component's separate area, click its button, and check the message produced by that click.

## What do the other examples show?

- [RegularDomComponentTest](RegularDomComponentTest.java): a component can look special but still use ordinary page elements. This test confirms it has no shadow root, types `student` into its input, and checks the value.
- [AkakceConsentShadowDomTest](AkakceConsentShadowDomTest.java): the same technique on a live consent panel. It clicks the acceptance button and checks that the button disappears. The website may change; start with the local example above.
