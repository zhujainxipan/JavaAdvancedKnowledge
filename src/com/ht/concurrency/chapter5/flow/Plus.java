package com.ht.concurrency.chapter5.flow;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by niehongtao on 16/7/13.
 * P1
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();



    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.j = msg.i + msg.j;
                Mutiply.bq.add(msg);
            } catch (InterruptedException e) {

            }
        }

    }
}
