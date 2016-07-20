package com.ht.generic.demo1;

/**
 * Created by niehongtao on 16/7/20.
 */
public class Test01 {

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("m1", "sssss");
//        String str = map.get("m1");

        // 使用object
        Tool tool = new Tool();
        tool.setObj(new Worker());
        Worker worker = (Worker) tool.getObj();

        // 使用泛型
        Tool1<Worker> tool1 = new Tool1<>();
        tool1.setT(new Worker());
        Worker worker1 = tool1.getT();
    }
}
