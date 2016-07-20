package com.ht.generic.demo4;

import java.util.ArrayList;

/**
 * Created by niehongtao on 16/7/20.
 */
public class Demo4 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("2222");
        list.add("333");
        dieDai(list);
    }


    private static void dieDai(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }



    private static void dieDai1(ArrayList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }


    private static <Q> void dieDai2(ArrayList<Q> q) {
        for (int i = 0; i < q.size(); i++) {
            Q q1 = q.get(i);
            System.out.println(q1);
        }
    }
}
