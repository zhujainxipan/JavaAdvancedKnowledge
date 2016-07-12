package com.ht.concurrency.chapter5.consumerandproductor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by niehongtao on 16/7/12.
 */
public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;


    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        Random r = new Random();
        try {
            if (true) {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getIntData() * data.getIntData();
                    Thread.sleep(r.nextInt(SLEEPTIME));
                    System.out.println(data.getIntData() + "*" + data.getIntData() + "=" + re);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
