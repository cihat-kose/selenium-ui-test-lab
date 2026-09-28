# YouTube Search: Open the 80th Video

1. Open YouTube and search for **Selenium**.
2. Scroll down to load more results. The test allows up to 12 scroll attempts and stops earlier if the page stops loading results.
3. Check that at least 80 video cards loaded and that the 80th has a title.
4. Open the 80th result and check that the browser navigated to a video page.

The test uses a live site, so YouTube's consent flow, results, and loading behavior can change. It fails with the number of results loaded if the page does not provide 80 cards within the limit.
