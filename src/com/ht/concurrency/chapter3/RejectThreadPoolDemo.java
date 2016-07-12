package com.ht.concurrency.chapter3;

import java.util.concurrent.*;

/**
 * Created by niehongtao on 16/7/12.
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":thread id" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
                }
        );

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.submit(myTask);
            Thread.sleep(1000);
        }
    }
}
