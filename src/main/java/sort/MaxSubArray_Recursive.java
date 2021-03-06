package sort;

import java.util.Arrays;

/**
 * 4.1-3 最大子数组递归解法。Θ(n*lgn)
 *
 * @author 周何圳 2018年05月28日 新建
 */
public class MaxSubArray_Recursive {

    public MaxSubArrayBean findMaxSubArray(int[] src) {
        if (src.length <= 2) {
            System.out.println("Error: Array length must be >= 2!");
            return null;
        }

        MaxSubArrayBean m = findMaxSubArray(src, 0, src.length - 1);
        System.out.println(m);
        return m;
    }

    // 递归程序,主要是分解和合并部分
    private MaxSubArrayBean findMaxSubArray(int[] src, int start, int end) {
        if (start == end) {
            return new MaxSubArrayBean(start, end, src[start]);
        }
        int mid = (start + end) / 2;
        // 左边最大值
        MaxSubArrayBean leftMax = findMaxSubArray(src, start, mid);
        // 右边最大值
        MaxSubArrayBean rightMax = findMaxSubArray(src, mid + 1, end);
        // 左右两边合并后集合的最大值
        MaxSubArrayBean crossMidMax = findMaxSubArrayCrossMid(src, start, end);

        if (leftMax.sumValue >= rightMax.sumValue && leftMax.sumValue >= crossMidMax.sumValue) {
            return leftMax;
        } else if (rightMax.sumValue >= leftMax.sumValue && rightMax.sumValue >= crossMidMax.sumValue) {
            return rightMax;
        } else
            return crossMidMax;
    }

    // 处理部分，这部分是核心逻辑。这部分的时间复杂度应该是Θ(n)
    private MaxSubArrayBean findMaxSubArrayCrossMid(int[] src, int start, int end) {
        int mid = (start + end) / 2;
        int leftSumTemp = 0, rightSumTemp = 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int leftIndex = 0, rightIndex = 0;
        // 从mid往前最大
        for (int i = mid; i >= start; i--) {
            leftSumTemp += src[i];
            if (leftSum < leftSumTemp) {
                leftSum = leftSumTemp;
                leftIndex = i;
            }
        }

        // 从mid往后最大
        for (int i = mid; i <= end; i++) {
            rightSumTemp += src[i];
            if (rightSum < rightSumTemp) {
                rightSum = rightSumTemp;
                rightIndex = i;
            }
        }

        return new MaxSubArrayBean(leftIndex, rightIndex, leftSum + rightSum - src[mid]);
    }

    public static void main(String[] args) {
        MaxSubArray_Recursive m = new MaxSubArray_Recursive();
        for (int[] testData : TestData.MaxSubArrayTestData()) {
            System.out.println("Test: " + Arrays.toString(testData));
            m.findMaxSubArray(testData);
        }
    }

}
