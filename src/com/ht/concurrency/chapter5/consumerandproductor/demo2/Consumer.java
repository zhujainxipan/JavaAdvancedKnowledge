package com.ht.concurrency.chapter5.consumerandproductor.demo2;

/**
 * Created by niehongtao on 16/7/14.
 */

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private String name;
    BlockingQueue<Product> s;
    public Consumer(String name, BlockingQueue<Product> s) {
        this.name = name;
        this.s = s;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(name + "准备消费产品.");
                Product product = s.take();
                System.out.println(name + "已消费(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}