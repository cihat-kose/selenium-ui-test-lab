# Wait for a Delayed JavaScript Alert

The executable version of this task is in [Waits](../../_08_Waits/_04_ExplicitWaitAlert/Task.md). It uses the local `javascript-alerts.html` fixture instead of relying on DemoQA's current page layout.

Follow that task to click the delayed-alert button, wait with `WebDriverWait`, check the dialog text, accept it, and verify the page response. A second copy of the same test is unnecessary.
