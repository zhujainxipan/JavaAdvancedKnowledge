package com.ht.generic.demo2;

/**
 * Created by niehongtao on 16/7/20.
 */
public class Demo<T> {
    public void show(T t) {
        System.out.println("show:" + t);
    }

    public <E> void fun(E e) {
        System.out.println("show:" + e);
    }

    public static <W> void method (W w) {
        System.out.println("show:" + w);
    }


    public static void main(String[] args) {
        Demo<String> demo = new Demo<>();
        demo.show("hello");

        Demo<Integer> demo1 = new Demo<>();
        demo1.show(2);

        demo1.fun("fdfdfdf");
        demo1.fun(122);



    }
}
