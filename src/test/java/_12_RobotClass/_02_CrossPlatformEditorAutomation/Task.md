
# Type in a System Text Editor with Robot

Run `CrossPlatformTextEditorTest` from a visible Windows or macOS desktop.

1. The test starts Notepad on Windows or TextEdit on macOS.
2. After a short observation pause, Robot types **Hello from Robot Class**.
3. Robot closes the editor using the platform's keyboard shortcut.

The test is skipped on unsupported systems and headless sessions. Focus can vary by desktop and editor startup time, so this remains a manual demonstration rather than a CI check.
