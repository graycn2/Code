package com.pyh;

import org.junit.Test;

import java.util.*;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AccessLimitControl {
    // 任意时刻仅允许最多3个线程获取许可:
    final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception {
        // 如果超过了许可数量,其他线程将在此等待:
        semaphore.acquire();
        try {
            // TODO:
            return UUID.randomUUID().toString();
        } finally {
            semaphore.release();
        }

        // 指定等待时间3秒内获取到许可:
        // TODO:
    }

    @Test
    public void test1(){
        Map<String, String> map = new ConcurrentHashMap<>();
// 在不同的线程读写:
        map.put("A", "1");
        map.put("B", "2");
        System.out.println(map.get("A"));
    }

}
