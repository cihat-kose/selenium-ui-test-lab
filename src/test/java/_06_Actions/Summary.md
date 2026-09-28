# Selenium Actions

Selenium's `Actions` class builds mouse and keyboard gestures that involve more than a basic click or `sendKeys()` call. Chain the steps, then call `.perform()` to send them to the browser.

```java
new Actions(driver)
        .moveToElement(menu)
        .click()
        .perform();
```

## What the examples cover

- **Keyboard:** [KeyboardActionsTest](./_04_KeyboardActions/KeyboardActionsTest.java) presses a space key and key combinations on a local page. The page records each key event, and the tests check the log and final input value.
- **Mouse:** [MouseActionsTest](./_05_MouseActions/MouseActionsTest.java) demonstrates hover, click, double-click, right-click, click-and-hold, and drag-and-drop on practice pages. The double-click example checks the page message.
- **Context and double-click alerts:** [ContextClickAndDoubleClickTest](./_01_ContextClickAndDoubleClick/ContextClickAndDoubleClickTest.java) performs the gesture and checks the alert or page response.
- **Drag and drop:** the jQuery UI exercise checks its **Dropped!** result. The three matching and distribution exercises also check that each city or student ended up in its expected drop area.

Most mouse examples use public demo sites, which can change. Plain `mvn test` includes the local keyboard lesson; run a live example separately when needed.
