package com.pyh;

import org.junit.Test;

public class Test1 {
    @Test
    public void thread1(){
        Thread t = new Thread(()->{
            System.out.println("start new thread");
        });
        t.start();
    }

    @Test
    public void thread2(){
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }

    @Test
    public void thread3() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("end");
    }

    @Test
    public void thread4() throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(100); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

    class MyThread1 extends Thread {
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");
            }
        }
    }

    @Test
    public void thread5() throws InterruptedException {
        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

    class MyThread2 extends Thread {
        public void run() {
            Thread hello = new HelloThread();
            hello.start(); // 启动hello线程
            try {
                hello.join(); // 等待hello线程结束
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }
            hello.interrupt();
        }
    }

    class HelloThread extends Thread {
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

}
