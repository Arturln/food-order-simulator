package utils;

public class WaitMessageDemonThread extends Thread {

    private static volatile boolean waitFlag = false;

    public WaitMessageDemonThread() {
        this.setDaemon(true);
    }

    public static void getMessage() {
        waitFlag = true;
    }

    public static void stopMessage() {
        waitFlag = false;
    }

    @Override
    public void run() {
        while (true) {
            if (waitFlag) {
                System.out.println("Wait..wait..wait");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
