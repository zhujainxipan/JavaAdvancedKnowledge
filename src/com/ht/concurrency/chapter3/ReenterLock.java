package com.ht.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niehongtao on 16/7/8.
 * 3.1重入锁
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            i++;
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReenterLock rl = new ReenterLock();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
