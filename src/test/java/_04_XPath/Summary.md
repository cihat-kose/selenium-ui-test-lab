# XPath

XPath locates page elements by their tag, attributes, text, and relationship to other elements. For example, `//input[@name='email']` finds an input by its `name`, and `//a[contains(@href, 'register')]` finds a link whose URL contains a word.

[`RegistrationWithXPathTest`](RegistrationWithXPathTest.java) uses XPath for every field in the Parabank registration form and checks the welcome message.

The [practice folder](_01_Practice/Task.md) repeats common interactions with XPath so you can compare the locator syntax. It checks submitted form values, login text, search text, a calculator sum, and the closing of ordinary HTML dialogs. These are public demos and can change.

Compare these examples with the parallel [CSS selector chapter](../_03_CssSelector/Summary.md).
