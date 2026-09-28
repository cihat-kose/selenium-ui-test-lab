package utility;

import java.time.Instant;

/** Creates readable, non-personal test values for repeatable registration exercises. */
public final class TestData {
    private TestData() {
    }

    /** Returns a readable username with a short suffix for routine repeated runs. */
    public static String uniqueUsername(String name) {
        String usernameBase = name.toLowerCase().replaceAll("[^a-z0-9]+", "");
        if (usernameBase.isEmpty()) {
            throw new IllegalArgumentException("name must contain at least one letter or digit");
        }
        int suffix = (int) (Instant.now().toEpochMilli() % 10_000);
        return usernameBase + suffix;
    }

    /**
     * Returns a readable address at the reserved example.com domain.
     * The short numeric suffix distinguishes routine repeat runs without cluttering the address.
     */
    public static String uniqueExampleEmail(String name) {
        String emailName = name.toLowerCase().replaceAll("[^a-z0-9]+", ".").replaceAll("^\\.|\\.$", "");
        if (emailName.isEmpty()) {
            throw new IllegalArgumentException("name must contain at least one letter or digit");
        }
        int suffix = (int) (Instant.now().toEpochMilli() % 10_000);
        return emailName + suffix + "@example.com";
    }
}
