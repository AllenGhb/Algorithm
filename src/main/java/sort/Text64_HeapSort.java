package sort;

import java.util.Arrays;

/**
 * 堆排序算法思路 
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆; 
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 *
 * @author 周何圳 2018年05月29日 新建
 */
public class Text64_HeapSort {

    Prac625_Max_Heapify_NoRescursive heapify = new Prac625_Max_Heapify_NoRescursive(); // 调整堆
    Text63_build_max_heap buildMaxHeap = new Text63_build_max_heap(); // 建堆

    public void heap_sort(int a[]) {
        int lastHeapEleIndex = a.length - 1;
        buildMaxHeap.buildMaxHeap(a);
        // exchange a[0] and the last element in heap
        int temp = a[0];
        a[0] = a[lastHeapEleIndex];
        a[lastHeapEleIndex] = temp;
        // -2 的原因是因为排除了a[0]和a[lastHeapEleIndex]的建堆和调整堆操作
        int iterater = a.length - 2;
        while (--iterater > 0) {
            lastHeapEleIndex--;
            heapify.maxHeapify_NoRescursive(a, 0, lastHeapEleIndex);
            // exchange a[0] and the last element in heap
            temp = a[0];
            a[0] = a[lastHeapEleIndex];
            a[lastHeapEleIndex] = temp;
        }
        System.out.println("Sort result: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        Text64_HeapSort sort = new Text64_HeapSort();
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        sort.heap_sort(a);
        a = new int[] { 4, 1 };
        sort.heap_sort(a);
        a = new int[] { 4 };
        sort.heap_sort(a);
    }

}
