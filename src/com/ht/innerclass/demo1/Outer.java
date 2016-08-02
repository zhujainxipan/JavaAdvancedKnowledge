package com.ht.innerclass.demo1;

/**
 * Created by niehongtao on 16/8/2.
 */
public class Outer {
    int x = 3;
    void method() {
        final int y = 4;
        class Inner {
            void function() {
                System.out.println(y + x);
            }
        }

        new Inner().function();
    }
}
