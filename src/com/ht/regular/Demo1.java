package com.ht.regular;

/**
 * Created by niehongtao on 16/8/9.
 */
public class Demo1 {
    public static void main(String[] args) {
        String qq = "a38703402948";
        // 常规做法
        boolean checkQQ = checkQQ(qq);
        System.out.println(checkQQ);

        // 使用正则表达式
        String regex = "[1-9][0-9]{4,14}";
        boolean b = qq.matches(regex);
        System.out.println(b);
    }


    private static boolean checkQQ(String qq) {
        int len = qq.length();

        if (len < 5 || len > 15) {
            System.out.println(qq + "号的长度不合法");
            return false;
        }

        if (qq.startsWith("0")) {
            System.out.println(qq + "号以0开头了");
            return false;
        }

        try {
            long num = Long.parseLong(qq);
        } catch (NumberFormatException e) {
            System.out.println(qq + "号含有字母");
            return false;
        }

        return true;

    }
}
