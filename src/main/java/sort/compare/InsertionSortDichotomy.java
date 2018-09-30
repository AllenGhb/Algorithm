package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-插入排序
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- O(nlogn)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class InsertionSortDichotomy {

    /**
     * 二分插入排序算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void insertionSortDichotomy(int[] a, int length) {
        for (int i = 1; i < length; i++) {
            /** 右手抓到一张扑克牌 **/
            int key = a[i];
            /** 拿在左手上的牌总是排序好的，所以可以用二分法 **/
            int left = 0;
            /** 手牌左右边界进行初始化 **/
            int right = i - 1;
            /** 采用二分法定位新牌的位置 **/
            while (left <= right) {
                int mid = (left + right) / 2;
                if (a[mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            /** 将欲插入新牌位置右边的牌整体向右移动一个单位 **/
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            /** 将抓到的牌插入手牌 **/
            a[left] = key;
        }
    }

    public static void main(String[] args) {
        /** 从小到大二分插入排序 **/
        int[] a = { 5, 2, 9, 4, 7, 6, 1, 3, 8 };
        insertionSortDichotomy(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
