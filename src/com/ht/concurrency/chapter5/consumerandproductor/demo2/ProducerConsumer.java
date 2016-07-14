package com.ht.concurrency.chapter5.consumerandproductor.demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by niehongtao on 16/7/14.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);

        ExecutorService service = Executors.newCachedThreadPool();
        Producer p = new Producer("张三", queues);
        Producer p2 = new Producer("李四", queues);
        Consumer c = new Consumer("王五", queues);
        Consumer c2 = new Consumer("老刘", queues);
        Consumer c3 = new Consumer("老林", queues);
        service.submit(p);
        service.submit(p2);
        service.submit(c);
        service.submit(c2);
        service.submit(c3);

    }

}
