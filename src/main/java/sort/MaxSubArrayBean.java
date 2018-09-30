package sort;

/**
 * 最大子数组的返回值Bean - 最大子数组在原数组中的开始(startIndex),结束(endIndex)和这些值的和(sumValue).
 *
 * @author 周何圳 2018年05月28日 新建
 */
public class MaxSubArrayBean {

    public int startIndex;
    public int endIndex;
    public int sumValue;

    public MaxSubArrayBean(int startIndex, int endIndex, int sumValue) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.sumValue = sumValue;
    }

    @Override
    public String toString() {
        return "MaxSubArrayBean{" + "startIndex=" + startIndex + ", endIndex=" + endIndex + ", sumValue="
                + sumValue + '}';
    }
}
