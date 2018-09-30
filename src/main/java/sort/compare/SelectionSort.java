package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-选择排序
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- O(n^2)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 不稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class SelectionSort {

    /**
     * 交换两数的位置
     *
     * @author 周何圳 2018年09月30日 新建
     */
    private static void swap(int[] a, int i, int j) {
        a[i] = a[j] ^ a[i];
        a[j] = a[i] ^ a[j];
        a[i] = a[j] ^ a[i];
    }

    /**
     * 选择排序算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void selectionSort(int[] a, int length) {
        /** i为已排序序列的末尾 **/
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            /** 未排序序列 **/
            for (int j = i + 1; j < length; j++) {
                /** 找出未排序序列中的最小值 **/
                if (a[j] < min) {
                    min = j;
                }
            }
            if (min != i) {
                /** 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法 **/
                swap(a, min, i);
            }
        }
    }

    public static void main(String[] args) {
        /** 从小到大选择排序 **/
        int[] a = { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 };
        selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
