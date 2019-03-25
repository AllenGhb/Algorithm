package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-插入排序
 * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class InsertionSort {

    /**
     * 插入排序算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void insertionSort(int[] a, int length) {

        // 数组为空或者只有一个元素的时候不需要排序
        if (a == null || length <= 1) {
            return;
        }

        /** 类似抓扑克牌排序 **/
        for (int i = 1; i < length; i++) {
            /** 右手抓到一张扑克牌,a[i]必须先存起来,不然后面会被a[j+1]给覆盖掉 **/
            int key = a[i];
            /** 拿在左手上的牌总是排序好的 **/
            int j = i - 1;
            /** 将抓到的牌与手牌从右向左进行比较 **/
            for (; j >= 0; j--) {
                /** 如果该手牌比抓到的牌大，就将其右移 **/
                if (a[j] > key) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                // System.out.println("插入中" + Arrays.toString(a));
            }
            /** 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的) **/
            a[j + 1] = key;
            // System.out.println("j="+ j);
            // System.out.println("结果" + Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        /** 从小到大插入排序 **/
        int[] a = { 6, 5, 3, 1, 8, 7, 2, 4 };
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
