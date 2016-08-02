package com.ht.innerclass.demo1;

/**
 * Created by niehongtao on 16/8/2.
 */
public class OuterClass {
    private String str;

    public void outerDisplay() {
        System.out.println("outerclass...");
    }


    public class InnerClass {
        public void innerDisplay() {
            str = "内部类内部类";
            System.out.println(str);
            outerDisplay();
        }
    }


    public InnerClass getInnerClass() {
        return new InnerClass();
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.getInnerClass();
        innerClass.innerDisplay();
    }
}
