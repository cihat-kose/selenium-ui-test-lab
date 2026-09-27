// ===========================
// Summary: Robot Class
// ===========================

Robot Class (Java AWT)
-----------------------
Robot Class is a part of Java's AWT package that allows interaction with native system input devices such as keyboard and mouse.
It is especially useful in GUI testing scenarios where Selenium WebDriver does not have access, such as interacting with OS-level dialogs.

Common Use Cases:
-----------------
1. Simulating mouse movement and clicks.
2. Simulating keyboard key presses (copy-paste, typing text).
3. Taking screenshots.
4. Working with clipboard (System copy/paste).

Key Methods:
------------
- mouseMove(int x, int y): Move mouse to screen coordinates.
- mousePress(int button): Simulate mouse button press (e.g., KeyEvent.BUTTON1_DOWN_MASK).
- mouseRelease(int button): Release mouse button.
- keyPress(int keycode): Press keyboard key (e.g., KeyEvent.VK_CONTROL).
- keyRelease(int keycode): Release key.
- createScreenCapture(Rectangle screenRect): Take screenshot.
- Using clipboard:
    StringSelection selection = new StringSelection("text");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

Why Use Robot Class:
--------------------
- To simulate real user interactions with keyboard/mouse.
- To handle native OS dialogs or popups.
- To test cross-platform behaviors with minimal external dependencies.

Important Notes:
----------------
- Robot actions affect the whole system (not browser-specific).
- Fixed coordinates can be unreliable on different screen sizes.
- Add short waits between actions to simulate realistic behavior (e.g., Thread.sleep or utility wait).

File selection examples:
------------------------
- `FileSelectionWithRobotTest` opens the native file picker and pastes the project's shared sample path. It requires a visible desktop session and does not assume a fixed number of TAB presses.
- `FileSelectionWithWebDriverTest` sends the same path directly to `input[type=file]` with WebDriver. It does not open the native dialog.
- Both tests verify the selected file name. The local fixture demonstrates the selection flow; it does not upload a file to a server.


See the [file selection lesson](../_15_FileUpload/Task.md) for the native Robot picker and direct WebDriver approaches side by side.
