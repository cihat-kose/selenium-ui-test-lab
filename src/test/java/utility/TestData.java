package utility;

import java.util.UUID;

/** Creates safe, unique values for repeated registration exercises. */
public final class TestData {
    private TestData() {
    }

    /** Returns a letters-and-digits username that is unlikely to collide between runs. */
    public static String uniqueUsername() {
        return "student" + UUID.randomUUID().toString().replace("-", "");
    }

    /** Returns a syntactically valid example address without using a real mailbox. */
    public static String uniqueExampleEmail() {
        return uniqueUsername() + "@example.com";
    }
}
