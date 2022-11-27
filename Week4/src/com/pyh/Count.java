package com.pyh;

public class Count {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }


//    Java的synchronized锁是可重入锁；
//
//死锁产生的条件是多线程各自持有不同的锁，并互相试图获取对方已持有的锁，导致无限等待；
//
//避免死锁的方法是多线程获取锁的顺序要一致。
}
