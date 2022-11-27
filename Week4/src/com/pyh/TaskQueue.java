package com.pyh;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

//    public synchronized void addTask(String s) {
//        this.queue.add(s);
//    }

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notify(); // 唤醒在this锁等待的线程
    }

//    public synchronized String getTask() {
//        while (queue.isEmpty()) {
//        }
//        return queue.remove();
//    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
