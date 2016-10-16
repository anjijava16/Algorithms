package com.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunilpatil on 10/13/16.
 */
public class ZooInfo {

    public static void main(String[] argv) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");

            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Printing zoo inventory");
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(100);
                            System.out.println("Printing record " + i);
                        } catch (Exception ex) {

                        }
                    }
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Printing zoo inventory");
                }
            });
            System.out.println("end");
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
