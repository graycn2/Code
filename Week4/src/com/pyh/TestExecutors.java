package com.pyh;

import java.util.concurrent.*;

public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        ExecutorService esc = new ThreadPoolExecutor(4,6,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        for (int i = 0;i < 6 ;i++){
            esc.submit(new Task(""+i));
        }

        esc.shutdown();
    }
}

class Task implements Runnable{
    private final String name;

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }

    public Task(String name) {
        this.name = name;
    }
}
