package string_matching;

public class RabinKarp {

    public static void RabinKarpAlogrithm(char[] T,char[] P,int d,int q){
        int n = T.length;
        int m = P.length;
        if(n < m) return;
        // h 为 m的最高次幂
        int h = 1;
        for(int i = 1; i <= m-1;i++){
            // % q 放在for循环内层主要是为了避免h值过大导致超出int类型的范围
            h = h * d % q;
        }
        // 计算出第一次比较的T子集和P字符串,这里用到秦九昭算法，如421=4*10^2+2*10+1
        int p = 0,t = 0;
        for(int i = 0; i < m; i++){
            t = (d * t + T[i]) % q;
            p = (d * p + P[i]) % q;
        }

        for(int s = 0; s < n - m + 1; s++){
            if( t == p){
                for(int i = 0 ; i < m ; i++ ){
                    if(T[i+s] == P[i] && i + 1 == m){
                        System.out.println("Pattern ocurs with shift:"+s);
                    }
                }
            }
            if(s < n - m){
                // t(s+1)=d*(t(s)-T[s+1]*d^(m-1))+T[s+m+1]
                t = ( d * (t - T[s] * h % q) + T[s+m]) % q;
            }
        }
        System.out.println("string matching ends");
    }

    public static void main(String[] args) {
        String strT="2359023141526739921";
        String strP="31415";
        char[] T = strT.toCharArray();
        char[] P = strP.toCharArray();
        int d = 10;
        // 所选质数
        int q = 13;
        RabinKarp.RabinKarpAlogrithm(T,P,d,q);
    }

}
