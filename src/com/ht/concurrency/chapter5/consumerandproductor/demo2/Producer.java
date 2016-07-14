package com.ht.concurrency.chapter5.consumerandproductor.demo2;

/**
 * Created by niehongtao on 16/7/14.
 */

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private String name;
    BlockingQueue<Product> s;

    public Producer(String name, BlockingQueue<Product> s) {
        this.name = name;
        this.s = s;
    }

    public void run() {
        try {
            while (true) {
                Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数
                System.out.println(name + "准备生产(" + product.toString() + ").");
                s.put(product);
                System.out.println(name + "已生产(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(500);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
}