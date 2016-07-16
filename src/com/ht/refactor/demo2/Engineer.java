package com.ht.refactor.demo2;

/**
 * Created by niehongtao on 16/7/17.
 */
public class Engineer extends Employee {


    public Engineer() {
        super();
    }

    @Override
    int getType() {
        return super.ENGINEER;
    }
}
