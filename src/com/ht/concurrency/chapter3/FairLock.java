package com.ht.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niehongtao on 16/7/8.
 * 公平锁示例
 */
public class FairLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "线程获得锁");
            } finally {
                lock.unlock();
            }
        }

    }


    public static void main(String[] args) {
        FairLock fl = new FairLock();
        Thread t1 = new Thread(fl, "thread-1");
        Thread t2 = new Thread(fl, "thread-2");
        t1.start();
        t2.start();
    }
}
