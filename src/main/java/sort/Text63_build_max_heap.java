package sort;

import java.util.Arrays;

/**
 * 调用Max_Heapify，构建最大堆算法。
 *
 * @author 周何圳 2018年05月29日 新建
 */
public class Text63_build_max_heap {
    private Prac625_Max_Heapify_NoRescursive h = new Prac625_Max_Heapify_NoRescursive();
    public void buildMaxHeap(int[] a){
        if(a.length <= 1)
            return;
        // 获取最大非叶子节点位置
        int last_non_leaf_index = a.length/2 - 1;
        // 遍历所有非叶子节点,构造大顶堆
        for (int i = last_non_leaf_index; i >= 0; i--) {
            h.maxHeapify_NoRescursive(a, i, a.length - 1);
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Text63_build_max_heap t = new Text63_build_max_heap();
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        t.buildMaxHeap(a);
    }
}
