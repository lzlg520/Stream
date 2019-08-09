package com.lzlg.interview.second;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaxValueTest {
    // 树塔问题
    public static void main(String[] args) {
        int[][] array = {
                {7},
                {3, 8},
                {4, 1, 0},
                {2, 7, 6, 5}
        };

        // 求出最大和
        /*
              7
            3   8
          4   1   0
        2   7   6   5
         */

        System.out.println(getMaxTree(array));

    }

    public static int getMaxTree(int[][] array) {
        int len = array.length;
        int[][] max = new int[len][len];

        int[][] path = new int[len][len];

        for (int i = 0; i < len; i++) {
            max[len - 1][i] = array[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (max[i + 1][j] > max[i + 1][j + 1]) {
                    max[i][j] = max[i + 1][j] + array[i][j];
                    path[i][j] = j;
                } else {
                    max[i][j] = max[i + 1][j + 1] + array[i][j];
                    path[i][j] = j + 1;
                }
            }
        }

        System.out.println("最大数值和为：" + max[0][0]);

        System.out.print("路径为：" + array[0][0]);

        int k = path[0][0];

        for (int i = 1; i <= len - 1; i++) {
            System.out.print("->" + array[i][k]);
            k = path[i][k];
        }

        System.out.println("\n=======>>>>>>>>>>>>");

        return max[0][0];
    }


    public static int getMaxSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
//            sum += getMaxValueInArray(array[i]);
            sum += getMaxValueByStream(array[i]);
        }

        return sum;
    }

    public static int getMaxValueInArray(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static int getMaxValueByStream(int[] array) {
        OptionalInt max = Arrays.stream(array).max();
        return max.orElse(0);
    }
}
