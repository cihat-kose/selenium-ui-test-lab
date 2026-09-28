# Native Dropdown Selection with Selenium

Selenium's `Select` class handles native HTML `<select>` elements. It does not apply to custom dropdown widgets built from other elements.

## Methods covered

- `selectByVisibleText()`
- `selectByValue()`
- `selectByIndex()`
- `getOptions()`
- `getFirstSelectedOption()`
- `getAllSelectedOptions()`
- `deselectAll()` (multi-select controls only)

`deselectAll()` is available only for multi-select controls. The basic lesson uses a single-select dropdown and explains that limitation without calling the method.

The basic example includes short observation pauses so learners can see each selection change. The pauses are not synchronization; the [README wait guidance](../../../../../README.md#waits-and-browser-lifecycle) explains when fixed pauses are appropriate.

## Practice order

1. [SelectDropdownTest](SelectDropdownTest.java): select an option by text, value, or index, inspect the choices, and assert the selection.
2. [Calculator operations](../_02_CalculatorOperations/Summary.md): select arithmetic operations and check the calculated results. This follow-up exercise also uses Actions and waits from later chapters.
