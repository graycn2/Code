package com.pyh;

import org.junit.Test;

public class Test2 {
    @Test
    public void test1() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

    static class Counter {
        public static int count = 0;
    }

    class AddThread extends Thread {
        public void run() {
            for (int i=0; i<10000; i++) { Counter.count += 1; }
        }
    }

    class DecThread extends Thread {
        public void run() {
            for (int i=0; i<10000; i++) { Counter.count -= 1; }
        }
    }
}
