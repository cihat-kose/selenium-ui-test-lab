# Keyboard Actions Practice

This lesson uses the local `keyboard-actions.html` page so the expected key events do not depend on a public demo site.

Run `KeyboardActionsTest` and follow its four examples:

1. Send `SPACE` to the input and check the key shown on the page.
2. Send `CTRL+A` with `Keys.chord()` and check that the page received the combination.
3. Send `SHIFT+T` with a chord and check the reported key.
4. Use an `Actions` chain for `CTRL+A` followed by `DELETE`; check that the input is empty and both keys were received.

The page records browser keyboard events in `#key-log`. It prevents the space and delete keys from changing the page in ways unrelated to the lesson.
