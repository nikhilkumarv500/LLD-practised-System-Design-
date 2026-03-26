public class TimeoutHelper {
    private static Thread timerThread;

    public static void startTimeout(int milliseconds) {
        timerThread = new Thread(() -> {
            try {
                Thread.sleep(milliseconds);
                System.out.println("⚠ Timeout! Exiting...");
                System.exit(0);
            } catch (InterruptedException e) {}
        });
        timerThread.start();
    }

    public static void cancelTimeout() {
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }
    }
}
