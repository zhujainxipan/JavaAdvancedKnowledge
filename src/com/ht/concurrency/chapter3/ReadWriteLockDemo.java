package com.ht.concurrency.chapter3;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by niehongtao on 16/7/12.
 * 读写锁
 */
public class ReadWriteLockDemo {
//    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock =
            new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value;


    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }


    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnalbe = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnalbe).start();
        }

    }
}
