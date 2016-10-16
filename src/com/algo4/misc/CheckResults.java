package com.algo4.misc;

/**
 * Created by sunilpatil on 10/12/16.
 */
public class CheckResults {
    private static int counter = 0;

    public static void main(String[] argv) throws InterruptedException {
        new Thread(() -> {
            try {
                for (int i = 0; i < 500; i++) {
                    Thread.sleep(10);
                    CheckResults.counter++;
                }
            } catch (Exception ex) {
            }
        }).start();

        while (CheckResults.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(100);
        }
        System.out.println("Reached!");
    }

}
