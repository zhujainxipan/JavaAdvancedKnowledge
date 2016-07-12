package com.ht.concurrency.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by niehongtao on 16/7/12.
 * CountDownLatch demo
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();


    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check 完成");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.execute(demo);
        }

        end.await();

        System.out.println("火箭发射");

        exec.shutdown();
    }
}
