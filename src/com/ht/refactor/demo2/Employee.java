package com.ht.refactor.demo2;


/**
 * Created by niehongtao on 16/7/17.
 */
public abstract class Employee {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    Employee() {
    }

    abstract int getType();

    static Employee create(int type) {
        switch (type) {
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new Salesman();
            case MANAGER:
                return new Manager();
            default:
                throw new IllegalStateException("incorrect type code values");
        }
    }


}
