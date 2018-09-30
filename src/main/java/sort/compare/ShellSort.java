package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-希尔排序
 * 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
 * 最优时间复杂度 ---- O(n)
 * 平均时间复杂度 ---- 根据步长序列的不同而不同。
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 不稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class ShellSort {

    /**
     * 希尔算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void shellSort(int[] a, int length) {
        int h = 0;
        while (h <= length) {
            /** 生产初始增量 **/
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                int j = i - h;
                int key = a[i];
                while (j >= 0 && a[j] > key) {
                    a[j + h] = a[j];
                    j = j - h;
                }
                a[j + h] = key;
            }
            /** 递减增量 **/
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        /** 从小到大希尔排序 **/
        int[] a = { 5, 2, 9, 4, 7, 6, 1, 3, 8 };
        shellSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
