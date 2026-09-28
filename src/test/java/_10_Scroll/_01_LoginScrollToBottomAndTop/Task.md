 Task: Scroll to Bottom and Top after Login

# Scroll After Login

Run `ScrollPageAfterLoginTest` on the OrangeHRM public demo.

1. Sign in with the demo credentials used in the test.
2. Wait for the dashboard and check that the URL changed to the dashboard page.
3. Use `JavascriptExecutor` to scroll to the document bottom and wait until the bottom is visible.
4. Scroll back to the top and check that the page offset is zero.

This is a live-site example; the public demo can change or become unavailable. The scroll position checks verify the browser movement after login.
