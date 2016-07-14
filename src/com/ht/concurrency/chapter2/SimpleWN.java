package com.ht.concurrency.chapter2;

/**
 * Created by niehongtao on 16/7/14.
 */
public class SimpleWN {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "t1 start");
                try {
                    System.out.println(System.currentTimeMillis() + "t1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "t1 end");
            }
        }
    }


    public static class T2 extends Thread {


        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T2 start");
                object.notify();
                System.out.println(System.currentTimeMillis() + "T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }

        }
    }


    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }


}
