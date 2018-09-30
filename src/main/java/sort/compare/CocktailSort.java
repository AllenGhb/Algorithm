package sort.compare;

import java.util.Arrays;

/**
 * 比较排序-鸡尾酒排序
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * @author 周何圳 2018年09月30日 新建
 */
public class CocktailSort {

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
     * 鸡尾酒排序算法
     *
     * @param a 待排序的数组
     * @param length 待排序的数组的长度
     * @author 周何圳 2018年09月30日 新建
     */
    private static void cocktailSort(int[] a,int length){
        /** 初始化边界 **/
        int left = 0;
        int right = length - 1;
        while(left < right){
            /** 前半轮,将最大元素放到后面 **/
            for(int i = left ; i < right ; i++){
                if(a[i] > a[i+1]){
                    swap(a,i,i+1);
                }
            }
            right--;
            /** 后半轮,将最小元素放到前面 **/
            for(int i = right ; i > left; i--){
                if(a[i - 1] > a[i]){
                    swap(a,i-1,i);
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        /** 从小到大定向冒泡排序 **/
        int[] a = { 6, 5, 3, 1, 8, 7, 2, 4 };
        cocktailSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }

}
