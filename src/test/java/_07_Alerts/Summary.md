# JavaScript Alerts

## What is an alert?

A JavaScript alert is a small browser dialog created by page code. It is not an HTML element, so Selenium cannot locate it with `findElement()`.

## What does Selenium do?

First switch from the page to the dialog with `driver.switchTo().alert()`. Selenium's `Alert` methods match the dialog:

- `getText()` reads its message.
- `accept()` chooses **OK**.
- `dismiss()` chooses **Cancel**.
- `sendKeys()` enters text in a prompt.

## What does this lesson test?

[`JavaScriptAlertsTest`](./_03_LocalJavaScriptAlerts/JavaScriptAlertsTest.java) opens a local page and checks four results: accepting an alert, dismissing a confirmation, entering text in a prompt, and right-clicking an area to open an alert. The delayed alert example is in [Waits](../_08_Waits/_04_ExplicitWaitAlert/DelayedAlertWaitTest.java); it uses `WebDriverWait` to wait until the dialog appears.

Each test checks both the dialog message and the page result after handling it. The local fixture makes these basic examples repeatable without relying on an external demo site.
