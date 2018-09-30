package chap02_GettingStarted;

import java.util.Arrays;

/**
 * 1. 归并排序源代码 p17
 * 2. 练习题2.3-2 （方法new_merge） p22
 *
 * @author 周何圳 2018年05月30日 新建
 */
public class Text2_3_MergeSort {

    public void mergeSort(int[] src,int begin,int end){

        int mid = (begin + end) / 2;

        if(begin < mid ){
            mergeSort(src,begin,mid);
        }
        if(mid + 1 < end){
            mergeSort(src,mid + 1,end);
        }

        /**
         * 带"哨兵"的merge
         */
        merge(src, begin, mid, end);

    }

    private void merge(int[] src,int begin,int mid,int end){

        if(src.length <= 1){
            return;
        }

        // 初始化左右两个子数组,并且让数组末尾是"哨兵"
        int[] left = new int[mid - begin + 2];
        int[] right = new int[end - mid + 1];


    }



    public static void main(String[] args) {
        Text2_3_MergeSort t = new Text2_3_MergeSort();

        int e[] = {8,7,2,5,9,8,5};
        t.mergeSort(e, 0, e.length - 1);
        System.out.println(Arrays.toString(e));

        int a[] = {8,7,2,5,9,8};
        t.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int b[] = {8,7};
        t.mergeSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));

        int c[] = {8};
        t.mergeSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));

        int d[] = {};
        t.mergeSort(d, 0, d.length - 1);
        System.out.println(Arrays.toString(d));

        int f[] = {8,7,2,10, 100, 99, 80, 98};
        t.mergeSort(f, 0, f.length - 1);
        System.out.println(Arrays.toString(f));
    }

}
