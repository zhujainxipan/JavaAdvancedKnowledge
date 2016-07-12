package com.ht.concurrency.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by niehongtao on 16/7/12.
 * 3.1.3允许多个线程同时访问:信号量
 */
public class SemapDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);


    @Override
    public void run() {
        try {
            semp.acquire();
            // 模拟耗时操作
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId() + ":done");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.execute(demo);
        }
    }
}
