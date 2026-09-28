# Wait for a Delayed Alert

Run `DelayedAlertWaitTest` on the local `javascript-alerts.html` page.

1. Click **Open delayed alert**. The page waits one second before opening a native JavaScript alert.
2. Use `WebDriverWait` with `ExpectedConditions.alertIsPresent()` to wait for the dialog.
3. Check its message and accept it.
4. Wait for and check **Delayed alert accepted.** on the page.

This example demonstrates a condition wait; it does not sleep for a guessed five-second duration.
