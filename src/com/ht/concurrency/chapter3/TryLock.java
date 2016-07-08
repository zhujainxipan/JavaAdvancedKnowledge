package com.ht.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niehongtao on 16/7/8.
 */
public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {

                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + "my job done");
                            } finally {
                                lock2.unlock();
                            }
                        }

                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {

                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + "my job done");
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        TryLock tl1 = new TryLock(1);
        TryLock tl2 = new TryLock(2);

        Thread t1 = new Thread(tl1);
        Thread t2 = new Thread(tl2);

        t1.start();
        t2.start();
    }
}
