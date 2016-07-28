package com.ht.exception;

import java.util.Arrays;

/**
 * Created by niehongtao on 16/7/28.
 */
public class ExecptionMessageTest {
    public static void main(String[] args) {
        int result;
        try {
            result = 3 / 0;
        } catch (Exception e) {
            System.out.println("e.toString" + e.toString());
            System.out.println("...................");

            System.out.println("message" + e.getMessage());
            System.out.println("...................");

            StackTraceElement[] stackTrace = e.getStackTrace();
            String err = "";
            for (StackTraceElement stackTraceElement : stackTrace) {
                err = err + stackTraceElement.toString() + "\n";
            }
            System.out.println("err" + err);
            System.out.println("...................");

            e.printStackTrace();
        }

    }
}
