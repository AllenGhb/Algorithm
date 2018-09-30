package string_matching;

/**
 * KMP算法
 * 见 https://www.cnblogs.com/yjiyjige/p/3263858.html
 *
 * @author 周何圳 2018年09月11日 新建
 */
public class KMPStringMatching {

    private static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if(p[++j] == p[++k]){
                    //当两个字符相等时要跳过
                    next[j] = next[k]; // 等价于next[j] = next[0] = -1;
                }else{
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
            // 当j 为-1时,要移动的是i,当然j也要归0
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                // i不需要回溯了,j回到指定位置
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String tStr = "abceacabcdfbce";
        String pStr = "abcd";
        int index = KMP(tStr,pStr);
        System.out.println(index);
    }

}
