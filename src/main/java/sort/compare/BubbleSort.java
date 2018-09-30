package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-冒泡排序
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class BubbleSort {

    /**
     * 交换两数的位置
     *
     * @author 周何圳 2018年09月30日 新建
     */
    private static void swap(int[] a,int i,int j){
        a[i] = a[j] ^ a[i];
        a[j] = a[i] ^ a[j];
        a[i] = a[j] ^ a[i];
    }

    /**
     * 冒泡排序算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void bubbleSort(int[] a,int length){
        /** 每次最大元素就像气泡一样"浮"到数组的最后 **/
        for(int j = 0; j < length - 1; j++){
            /** 依次比较相邻的两个元素,使较大的那个向后移 **/
            for(int i = 0;i < length - 1 - j;i++){
                /** 如果条件改成a[i] >= a[i + 1],则变为不稳定的排序算法 **/
                if(a[i] > a[i + 1]){
                    swap(a,i,i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        /** 从小到大冒泡排序 **/
        int[] a = { 6, 5, 3, 1, 8, 7, 2, 4 };
        bubbleSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }

}
