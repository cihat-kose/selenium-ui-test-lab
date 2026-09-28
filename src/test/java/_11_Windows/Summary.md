 Windows (Multiple Windows) Summary

 - Definition:
   Selenium allows switching between multiple browser windows or tabs. Each window has a unique identifier called a window handle.

 - Key Methods:
   a) getWindowHandle(): Returns the handle of the current window
      Example: String mainWindow = driver.getWindowHandle();

   b) getWindowHandles(): Returns a Set of all open window handles
      Example: Set<String> allWindows = driver.getWindowHandles();

   c) switchTo().window(windowHandle): Switches the driver's context to the specified window

 - Use Case:
   Used when a click event opens a new tab or window, and you want to interact with elements inside that new context.

 - Best Practice:
   Always store the original window handle before opening a new window.
   After operations on the new window, switch back to the main window using:
   driver.switchTo().window(mainWindow);

 - Caution:
   If you do not switch to the correct window before interacting with it, Selenium may throw a NoSuchWindowException.