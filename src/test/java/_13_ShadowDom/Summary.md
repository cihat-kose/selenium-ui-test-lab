Shadow DOM: A Separate Area Inside a Page

Most page elements can be found directly with WebDriver. A web component can keep its internal elements inside a separate area called a Shadow DOM. The visible custom element is the shadow host. To find something inside it, first find the host, then get its shadow root, and search inside that root.

What the local test does:
1. Opens the project's small Shadow DOM page.
2. Finds the <consent-panel> host.
3. Uses getShadowRoot() to enter its separate area.
4. Clicks the Accept button inside that area.
5. Checks that the page now shows "Consent accepted".

The second test looks custom but has no Shadow DOM. It checks that getShadowRoot() throws NoSuchShadowRootException, then finds the input through ordinary DOM search and verifies the typed value.

An additional live-site example opens Akakce, finds the consent component's host, enters its Shadow DOM, and accepts the consent. It checks that the button disappears. This example depends on the live page continuing to use the same consent component; use the local test to learn the interaction without that dependency.

Remember:
- Native Shadow DOM: find host -> getShadowRoot() -> find the internal element.
- Regular DOM component: search inside the element as usual.
- A custom-looking component does not always use Shadow DOM.

The first two tests use local HTML fixtures. The Akakce example uses a live website.
