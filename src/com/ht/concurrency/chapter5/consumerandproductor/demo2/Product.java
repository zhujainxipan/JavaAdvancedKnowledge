package com.ht.concurrency.chapter5.consumerandproductor.demo2;

/**
 * Created by niehongtao on 16/7/14.
 */

public class Product {
    private int id;

    public Product(int id) {
        this.id = id;
    }

    public String toString() {// 重写toString方法
        return "产品：" + this.id;
    }
}
