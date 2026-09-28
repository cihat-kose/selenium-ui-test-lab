package utility;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

/** Resolves files copied to the Maven test classpath without relying on the IDE working directory. */
public final class TestResources {
    private TestResources() {
    }

    public static URL url(String resourceName) {
        String resourcePath = resourceName.startsWith("/") ? resourceName : "/" + resourceName;
        URL resource = TestResources.class.getResource(resourcePath);
        if (resource == null) {
            throw new IllegalArgumentException("Test resource not found on the classpath: " + resourcePath);
        }
        return resource;
    }

    public static Path path(String resourceName) {
        try {
            return Path.of(url(resourceName).toURI());
        } catch (URISyntaxException exception) {
            throw new IllegalStateException("Could not convert test resource to a file path: " + resourceName,
                    exception);
        }
    }
}
