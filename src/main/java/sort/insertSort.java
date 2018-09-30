package sort;

import java.util.Arrays;

public class insertSort {

    public static void insertionSort(int[] arr) {
        // 数组为空或者只有一个元素的时候不需要排序
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 开始插入排序，先假设元素组第一个元素属于已经排好序的A部分，依次从B部分取出元素，进行比较插入
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            for (; i >= 0; i--) {
                if (arr[i] > key) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
                System.out.println("插入中" + Arrays.toString(arr));
            }
            arr[i+1] = key;
            System.out.println("i="+ i);
            System.out.println("结果" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,4,8,6,9,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
