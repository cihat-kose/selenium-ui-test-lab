===============================
Selenium Actions Class Guide
===============================

1. What is Selenium Actions Class?
--------------------------------------
- The `Actions` class in Selenium WebDriver is used to simulate advanced user interactions.
- It enables:
  - Mouse actions like hover, right-click, double-click
  - Drag and drop
  - Complex keyboard interactions like key combinations

2. How to Use the Actions Class?
------------------------------------
- First, create an instance of the Actions class:
    Actions actions = new Actions(driver);

- Then chain your desired actions and end with:
    .perform();

3. Commonly Used Actions Methods
-------------------------------------
🖱 Mouse Actions:
  a) `moveToElement(element)` – Move the mouse to the given element (hover)
  b) `contextClick()` – Right-click on an element
  c) `doubleClick()` – Double-click on an element
  d) `clickAndHold()` – Click and hold without releasing
  e) `dragAndDrop(source, target)` – Drag one element to another

⌨ Keyboard Actions:
  f) `sendKeys(Keys.ENTER)` – Press keys
  g) `keyDown(Keys.CONTROL)` / `keyUp(Keys.CONTROL)` – Hold or release a key

🔗 Chaining Actions:
  h) `build()` – Builds a chain of actions
     → Must be followed by `.perform()`

4. Example – Chained Actions
-------------------------------
Example:
    actions.moveToElement(menu)
           .click()
           .sendKeys("Test")
           .build()
           .perform();

5. Basic Syntax Summary
---------------------------
    Actions actions = new Actions(driver);

    actions.moveToElement(element)
           .click()
           .contextClick()
           .perform();
