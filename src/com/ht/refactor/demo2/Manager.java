package com.ht.refactor.demo2;

/**
 * Created by niehongtao on 16/7/17.
 */
public class Manager extends Employee {
    @Override
    int getType() {
        return super.MANAGER;
    }
}
