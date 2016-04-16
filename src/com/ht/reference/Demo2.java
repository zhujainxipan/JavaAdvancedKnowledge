package com.ht.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by annuoaichengzhang on 16/4/16.
 */
public class Demo2 {
    public static void main(String[] args) {
        // 软引用,没有队列,可以有
        String hello = new String("hello");//强引用
        SoftReference sr = new SoftReference(hello);
        hello = "111";
        System.out.println(sr.get());

        // 弱引用,没有队列,可以有
        String hello1 = new String("hello");
        WeakReference<String> sr1 = new WeakReference<String>(hello1);
        hello1 = "222";
        System.out.println(sr1.get());
        System.gc();
        System.out.println(sr1.get());

        // 虚引用,有队列
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        String hello2 = new String("hello");
        PhantomReference<String> pr = new PhantomReference<>(hello2, queue);
        hello2 = "333";
        System.out.println(pr.get());
    }



}
