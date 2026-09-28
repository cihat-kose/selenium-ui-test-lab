# Handling Browser Alerts with Selenium

Browser-native JavaScript alerts block normal page interaction until they are accepted or dismissed. Selenium handles them through `driver.switchTo().alert()`. In-page dialogs are regular HTML elements and should be located and handled as web elements instead.

## Alert methods

- `getText()` reads the alert message.
- `accept()` confirms the alert.
- `dismiss()` cancels a confirmation or prompt.
- `sendKeys()` enters text into a prompt.

## Examples

- [Delayed DemoQA alert](./_01_DemoQAAlertWait/DemoQAAlertWaitTest.java) ([task](./_01_DemoQAAlertWait/Task.md)): wait for a timed alert, check its message, then accept it. The Waits chapter also uses this page to demonstrate explicit waits.
- [Guru99 context-menu and double-click alerts](./_02_Guru99Alert/Guru99AlertTest.java) ([task](./_02_Guru99Alert/Task.md)): perform the mouse gestures, verify both alert messages, and accept them. The Actions chapter demonstrates the same gestures.
- [The Internet JavaScript alerts](./_03_TheInternetHerokuappAlerts/JavaScriptAlertsTest.java) ([task](./_03_TheInternetHerokuappAlerts/Task.md)): accept a simple alert, dismiss a confirmation, respond to a prompt, and handle a context-menu alert.

The repeated examples keep each lesson runnable from its own chapter while connecting alert handling to the related Waits and Actions lessons.
