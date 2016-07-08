package com.ht.concurrency.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niehongtao on 16/7/8.
 * Condition用法
 */
public class ReenterLockcondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();



    @Override
    public void run() {
        lock.lock();
        try {
            condition.await();
            System.out.println("thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockcondition rlc = new ReenterLockcondition();
        Thread t1 = new Thread(rlc);
        t1.start();
        Thread.sleep(2000);
        // 通知线程继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
