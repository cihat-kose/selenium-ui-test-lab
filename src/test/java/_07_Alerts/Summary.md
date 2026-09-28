Selenium Alerts Overview
=========================

1. What is an Alert in Selenium?
--------------------------------
- An alert is a pop-up window used in web applications to display a message or request user interaction.
- In Selenium, alerts are handled using the method:
  driver.switchTo().alert();

2. Types of Alerts in Selenium
------------------------------
a) Simple Alert:
   - Displays a simple message.
   - Contains only an "OK" button.

b) Confirmation Alert:
   - Requests confirmation from the user.
   - Contains both "OK" and "Cancel" buttons.

c) Prompt Alert:
   - Requests user input (text).
   - Contains "OK" and "Cancel" buttons.

3. Handling Alerts in Selenium
------------------------------
- When an alert appears, the WebDriver loses control over the browser.
- You must switch to the alert before interacting with it:
  driver.switchTo().alert();

4. Common Alert Methods
-----------------------
- accept(): Clicks the "OK" button.
- dismiss(): Clicks the "Cancel" button.
- getText(): Retrieves the alert message.
- sendKeys(): Sends input text to a Prompt Alert.

5. Working with Alerts - Step-by-Step
-------------------------------------
a) Switch to the alert:
   Alert alert = driver.switchTo().alert();

b) Get the alert message:
   String alertText = alert.getText();

c) Click OK:
   alert.accept();

d) Click Cancel:
   alert.dismiss();

e) Send input (Prompt Alert):
   alert.sendKeys("text");

6. Examples
-----------
- Simple Alert:
  driver.switchTo().alert().accept();

- Confirmation Alert:
  Alert alert = driver.switchTo().alert();
  alert.dismiss();

- Prompt Alert:
  Alert alert = driver.switchTo().alert();
  alert.sendKeys("Selenium");
  alert.accept();

7. UnhandledAlertException in Selenium
--------------------------------------
- If you do not handle an alert when it appears, Selenium will throw an UnhandledAlertException.
- Always switch to the alert using driver.switchTo().alert() before attempting any interaction.
