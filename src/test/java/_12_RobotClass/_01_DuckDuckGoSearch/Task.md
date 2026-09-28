
# Paste and Search with Robot

Run `DuckDuckGoRobotSearchTest` in a visible desktop session.

1. Selenium opens DuckDuckGo and focuses its search field.
2. Java `Robot` pastes **Selenium Robot Class** from the clipboard and presses Enter.
3. Selenium waits for a result, checks that it has a title, and checks the search URL.
4. Robot moves the pointer to the center of the screen without clicking browser or operating-system controls.

This is a live-site desktop demonstration. It needs a visible desktop and clipboard access; it is not part of the automated CI suite.
