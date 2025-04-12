Waits Summary

 1. What are Waits in Selenium?
    Waits are used in Selenium to delay the execution until a certain condition is met.
    This prevents test failures caused by dynamic web elements that take time to load.

 2. Types of Waits:

    a) Implicit Wait:
       - Sets a default waiting time before throwing an exception if the element is not found.
       - Applied globally and works for all element searches.
       - Example:
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    b) Explicit Wait:
       - Waits for a specific condition (like visibility or clickability of an element).
       - Uses WebDriverWait and ExpectedConditions.
       - Example:
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

    c) Fluent Wait:
       - Advanced version of Explicit Wait.
       - Allows setting the frequency of checks and ignoring specific exceptions.
       - Example:
         FluentWait<WebDriver> wait = new FluentWait<>(driver)
             .withTimeout(Duration.ofSeconds(30))
             .pollingEvery(Duration.ofSeconds(5))
             .ignoring(NoSuchElementException.class);

 3. Common ExpectedConditions:
    - visibilityOfElementLocated()
    - elementToBeClickable()
    - alertIsPresent()
    - presenceOfElementLocated()
    - titleContains()

 4. Best Practice:
    - Use Implicit Wait for general setups.
    - Use Explicit or Fluent Wait for dynamic content that requires conditions.
