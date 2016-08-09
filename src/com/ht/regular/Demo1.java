package com.ht.regular;

/**
 * Created by niehongtao on 16/8/9.
 */
public class Demo1 {
    public static void main(String[] args) {
        String qq = "a38703402948";
        String regex = "[1-9][0-9]{4,14}";
        boolean b = qq.matches(regex);
        System.out.println(b);
    }
}
