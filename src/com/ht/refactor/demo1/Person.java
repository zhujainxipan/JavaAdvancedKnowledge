package com.ht.refactor.demo1;

/**
 * Created by niehongtao on 16/7/17.
 */
public class Person {
//    public static final int O = 0;
//    public static final int A = 1;
//    public static final int B = 2;
//    public static final int AB = 3;
//
//    private int bloodGroup;
//
//    public Person(int bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }
//
//    public int getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public void setBloodGroup(int bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }

    private BloodGroup bloodGroup;


    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Person(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
