package com.ht.concurrency.chapter2;

/**
 * Created by niehongtao on 16/7/14.
 */
public class ChangeObjectThread extends Thread{
    volatile boolean stopMe = false;


    public void setStopMe() {
        stopMe = true;
    }



    @Override
    public void run() {

        while (true) {
            if (stopMe) {
                System.out.println("exit by stop me");
                break;
            }

            //..........具体的业务代码

        }

    }
}
