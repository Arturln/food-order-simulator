package utils;

import java.util.Random;

public class WaitMessageDemonThread extends Thread {

    private static volatile boolean waitFlag = false;

    public WaitMessageDemonThread() {
        this.setDaemon(true);
    }

    public static void startPrintingWaitMessage() {
        waitFlag = true;
    }

    public static void stopPrintingWaitMessage() {
        waitFlag = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] messeges = {"Hello world", "Wait..wait..wait", "Error... i laugh of course", "Very nice day when rain"};
        while (true) {
            if (waitFlag) {
                String randomMessege = messeges[random.nextInt(messeges.length)];
                System.out.println(randomMessege);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
