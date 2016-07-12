package com.ht.concurrency.chapter5.consumerandproductor;

/**
 * Created by niehongtao on 16/7/12.
 */
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}
