package com.ht.listaddall;

import java.util.ArrayList;

/**
 * Created by annuoaichengzhang on 16/5/4.
 */
public class AddAllTest {
    public static void main(String[] args) {
        ArrayList<DemoEntity> l1 = new ArrayList();
        ArrayList<DemoEntity> l2 = new ArrayList();

//        l1.addAll(l2);
        System.out.println(l1.size());

        l1.addAll(l2);
//      System.out.println(l1.size());
//      System.out.println(l2.size());

//      l1.addAll(l2);
//      System.out.println(l1.size());

//      l1.removeAll(l2);
//      System.out.println(l1.size());
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setState("1");
        l2.add(demoEntity);

        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i).getState());
        }



    }
}
