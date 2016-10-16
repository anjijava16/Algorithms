package com.algo4.misc;

/**
 * Created by sunilpatil on 10/12/16.
 */
public class ReadInventoryThread extends Thread {
    public static void main(String[] argv) {
        System.out.println("begin");
        new ReadInventoryThread().start();
        (new Thread(new PrintData())).start();
        (new Thread(new PrintData())).start();
        (new Thread(new PrintData())).start();

        new ReadInventoryThread().start();
        System.out.println("end");

    }

    public void run() {
        System.out.println("Printing zoo inventory " + Thread.currentThread().getName());
    }
}
