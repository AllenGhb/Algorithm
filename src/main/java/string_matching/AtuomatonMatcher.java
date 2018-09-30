package string_matching;

/**
 * （Finite Automaton,FA）有限自动机字符串匹配算法
 * 
 * @author 周何圳 2018年09月11日 新建
 */
public class AtuomatonMatcher {

    // 假设字母表有256个字符
    final private static int NO_OF_CHARS = 256;

    /**
     * 对于状态y和给定的字符x,返回下一个状态。pLength为pat的长度
     *
     * @author 周何圳 2018年09月11日 新建
     */
    private static int getNextState(char[] pat, int pLength, int y, int x) {
        // 因为:pat[0...k-1]x 和 pat 的前面都是是一样的，如果x == pat[k]可直接返回。
        if (y < pLength && x == pat[y]) {
            return y + 1;
        }
        int ns, i; // ns 是下一个状态
        // ns 最终是最长的那个 prefix (同时也是pat[0..k-1]x)的后缀
        // 从可能得最长的前缀位置开始，找到后break,即为所求
        for (ns = y; ns > 0; ns--) {
            if (pat[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++) {
                    if (pat[i] != pat[y - ns + 1 + i])
                        break;
                }
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }

    /**
     * 构建FA有限自动机
     *
     * @author 周何圳 2018年09月11日 新建
     */
    private static void computeTF(char[] pat, int pLength, int[][] TF) {
        int state, x;
        for (state = 0; state <= pLength; state++) {
            for (x = 0; x < NO_OF_CHARS; ++x) {
                TF[state][x] = AtuomatonMatcher.getNextState(pat, pLength, state, x);
            }
        }
    }

    /**
     * 查找模式串
     *
     * @author 周何圳 2018年09月11日 新建
     */
    private static void matcher(char[] pat, char[] txt) {
        int pLength = pat.length;
        int tLength = txt.length;
        // P含有m个字母，于是，我们要构造的自动机就含有m+1个状态节点
        // TF数组存储FA有限状态机
        int[][] TF = new int[pLength + 1][NO_OF_CHARS];
        // 计算模式pat的有限自动机
        AtuomatonMatcher.computeTF(pat, pLength, TF);
        for (int i = 0; i < pLength + 1; i++) {
            for (int j = 0; j < NO_OF_CHARS; j++) {
                System.out.print(TF[i][j] + " ");
            }
            System.out.println();
        }
        int state = 0;
        for (int i = 0; i < tLength; i++) {
            state = TF[state][txt[i]];
            if (state == pLength) {
                int index = i - pLength + 1;
                System.out.println("pattern found at index:" + index);
            }
        }
    }

    public static void main(String[] args) {
        String strTxt = "1121131141121111211";
        String strPat = "1121";
        char[] txt = strTxt.toCharArray();
        char[] pat = strPat.toCharArray();
        AtuomatonMatcher.matcher(pat, txt);
    }

}
