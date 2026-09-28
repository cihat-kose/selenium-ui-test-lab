Topic: Native Dropdown Selection with Selenium's Select Class

This exercise uses the single-select dropdown on The Internet demo site.

1. Go to https://the-internet.herokuapp.com/dropdown
2. Use Selenium's `Select` class to interact with the dropdown.
3. Select options using each method and verify the selected option:
   - selectByVisibleText()
   - selectByValue()
   - selectByIndex()
4. Inspect all available options and the selected option using `getOptions()`, `getFirstSelectedOption()`, and `getAllSelectedOptions()`.
5. Note that `deselectAll()` is only supported for multi-select dropdowns; this page has a single-select dropdown.

The short pauses in the lesson are intentional so learners can observe each selection. They do not synchronize browser actions; see the README's wait guidance.
