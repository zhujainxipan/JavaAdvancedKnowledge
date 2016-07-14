package com.ht.concurrency.chapter5.consumerandproductor;

import java.util.concurrent.*;

/**
 * Created by niehongtao on 16/7/12.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
        Producter producter1 = new Producter(queue);
        Producter producter2 = new Producter(queue);
        Producter producter3 = new Producter(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(producter1);
        pool.execute(producter2);
        pool.execute(producter3);


        pool.execute(consumer1);
        pool.execute(consumer2);
        pool.execute(consumer3);

        Thread.sleep(10 * 1000);
        producter1.stop();
        producter2.stop();
        producter3.stop();
//
//        Thread.sleep(3000);
//        pool.shutdown();

    }
}
