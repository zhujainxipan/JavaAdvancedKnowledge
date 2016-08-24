package com.ht.array;

/**
 * Created by niehongtao on 16/8/24.
 */
public class Test1 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5};
        int[] arr2 = {3, 4, 5};

        // 前面是指明类型,后面是开辟空间的,所以需要在后面写具体多少个,前面不能写
        // 数组属于引用类型,需要用new来开辟空间
        int[] arr3 = new int[5]; // 4*5=20byte

        // 数组是使用下标来存储或取出数据的
        arr3[0] = 3;

        twoDimensionTest();

    }

    private static void twoDimensionTest() {
        // 定义一个二维数组,其中有三个一维数组,每个一维数组中有2个元素
        int[][] arr = new int[3][2];
        int[][] b = new int[][]{{2, 3, 4, 5}, {6, 7, 8, 9, 1}};
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }


    }


}
