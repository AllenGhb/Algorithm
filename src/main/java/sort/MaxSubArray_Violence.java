package sort;

import java.awt.*;
import java.util.Arrays;

/**
 * 习题4.1-2： 最大子数组暴力解法。Θ(n^2)
 *
 * @author 周何圳 2018年05月28日 新建
 */
public class MaxSubArray_Violence {

    public MaxSubArrayBean findMaxSubArray(int[] src){
        // 初始化最大子数组的返回值Bean
        MaxSubArrayBean rest = new MaxSubArrayBean(-1,-1,-1);
        // 数组校验
        if(src.length < 2){
            System.out.println("Error: Array length must be >= 2!");
            return null;
        }

        int sum = Integer.MIN_VALUE,tempSum = 0;
        for(int i = 0; i < src.length;i++){
            for(int j = i; j< src.length; j++){
                tempSum += src[j];
                if(sum < tempSum){
                    sum = tempSum;
                    rest.startIndex = i;
                    rest.endIndex = j;
                    rest.sumValue = sum;
                }
            }
            tempSum = 0;
        }
        System.out.println(rest);
        return rest;
    }

    public static void main(String[] args) {
        MaxSubArray_Violence m = new MaxSubArray_Violence();
        for(int[] testData : TestData.MaxSubArrayTestData()){
            System.out.println("Test: " + Arrays.toString(testData));
            m.findMaxSubArray(testData);
        }
    }

}
