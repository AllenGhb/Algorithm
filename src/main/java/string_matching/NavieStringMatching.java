package string_matching;

/**
 * 朴素字符串匹配算法
 *
 * @author 周何圳 2018年09月10日 新建
 */
public class NavieStringMatching {

    public static void main(String[] args) {
        String T = "欢迎访问allen博客，致力于大数据应用解决方案提供！";
        String P = "大数据应用解决方案";
        NavieStringMatching nsm = new NavieStringMatching();
        int index = nsm.stringMatcher(T, P);
        System.out.println("有效位移是： " + index);
    }

    public int stringMatcher(String T, String P) {
        int iTLen = T.length();
        int iPLen = P.length();
        for (int s = 0; s <= iTLen - iPLen; s++) {
            for (int i = 0; i < iPLen; i++) {
                if (T.charAt(s + i) == P.charAt(i) && i + 1 == iPLen) {
                    return s;
                } else if (T.charAt(s + i) != P.charAt(i)) {
                    break;
                }
            }
        }
        return -1;
    }

}
