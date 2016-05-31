package com.ht.exception;

/**
 * Created by annuoaichengzhang on 16/5/31.
 */
public class ExecptionTest {
    public static void main(String[] args) {
        int a;
        try {
            a = 3 / 0;
        } catch (Exception e) {
            a = 3;
        }

        a = a + 2;

        System.out.println(a + "");
    }
}
