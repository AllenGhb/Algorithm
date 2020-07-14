package recall;

public class EightQueen {

    // 全局或成员变量,下标表示行,值表示 queen 存储在哪一列
    int[] result = new int[8];

    public void calEightQueen(int row){
        if(row == 8){
            printQueens(result);
            // 8行棋子都放好了,已经没法再往下递归了,所以就return
            return;
        }
        // 每一行都有8种放法
        for(int column = 0; column < 8; ++column){
            // 有些放法不满足要求
            if(isOK(row,column)){
                // 第 row 行的棋子放到了column列
                result[row] = column;
                // 考察下一行
                calEightQueen(row+1);
            }
        }
    }

    // 判断row 行 column 列放置是否合适
    private boolean isOK(int row,int column){
        int leftup = column - 1,rightup = column + 1;
        // 逐行往上考察每一行
        for(int i= row-1;i>=0;--i){
            // 第 i 行的column列有棋子吗？
            if(result[i] == column) return false;
            // 第 i 行的column 列有棋子吗？
            if(leftup >=0){
                // 考察左上对角线：第i行leftup列有棋子吗？
                if(result[i] == leftup)
                    return false;
            }
            if(rightup < 8){
                // 考察右上对角线：第i行rightup列有棋子吗？
                if(result[i] ==rightup)
                    return false;
            }
            --leftup;++rightup;
        }
        return true;
    }

    // 打印出一个二维矩阵
    private void printQueens(int[] result){
        for(int row = 0; row < 8;++row){
            for(int column=0;column < 8 ;++column){
                if(result[row] == column)
                    System.out.print("O ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.calEightQueen(0);
    }
}
