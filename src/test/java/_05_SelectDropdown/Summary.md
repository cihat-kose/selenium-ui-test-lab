# Native Select Dropdowns

Selenium's `Select` class works with a native HTML `<select>` element. It can choose an option by visible text, `value`, or index, and can read available and selected options.

[`SelectDropdownTest`](SelectDropdownTest.java) tries the three selection methods in order and checks which option is selected each time. Its page uses a single-select dropdown, so `deselectAll()` is not applicable.

The [calculator exercise](_01_CalculatorOperations/Summary.md) is a follow-up: it selects an arithmetic operation and checks the displayed answer. That exercise also uses keyboard Actions and explicit waits.
