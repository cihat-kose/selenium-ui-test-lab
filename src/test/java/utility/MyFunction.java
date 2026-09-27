package utility;

public class MyFunction {

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("The fixed lesson delay was interrupted.", e);
        }
    }
}
