package com.algo4.misc;

/**
 * Created by sunilpatil on 10/12/16.
 */
public class PrintData implements Runnable {
    public static void main(String[] argv) {
        (new Thread(new PrintData())).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing records " + i + " " + Thread.currentThread().getName());
    }
}
