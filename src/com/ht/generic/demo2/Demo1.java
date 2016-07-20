package com.ht.generic.demo2;

/**
 * Created by niehongtao on 16/7/20.
 */
public class Demo1 {
    public void show(String s) {
        System.out.println("show:" + s);
    }

    public void show(Integer i) {
        System.out.println("show:" + i);
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.show(3);
        demo1.show("111111");
    }
}
