# Handle JavaScript Alerts

Run `JavaScriptAlertsTest` against the local `javascript-alerts.html` page.

1. Open the **Open alert** button, read the native dialog text, accept it, and check the page message.
2. Open the confirmation, dismiss it, and check that the page reports **Cancel**.
3. Open the prompt, enter **Hello, Selenium**, accept it, and check the displayed value.
4. Right-click the outlined area with Selenium `Actions`, accept the dialog, and check the page message.

The page uses real JavaScript `alert()`, `confirm()`, and `prompt()` dialogs. They are browser dialogs, not styled HTML pop-ups.
